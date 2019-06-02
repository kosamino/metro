/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MetroLineServiceImpl
 * Author:   houjing
 * Date:     2019/5/27 01:08
 * Description: metro line service impl
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.service.impl;

import com.demo.metro.domain.model.dao.MetroLineDAO;
import com.demo.metro.domain.model.dao.MetroRoutePlanDAO;
import com.demo.metro.domain.model.dao.MetroStationDAO;
import com.demo.metro.domain.model.entity.MetroDisplayModel;
import com.demo.metro.domain.model.entity.MetroLine;
import com.demo.metro.domain.model.entity.MetroRoute;
import com.demo.metro.domain.model.entity.MetroStation;
import com.demo.metro.service.MetroLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈metro line service impl〉
 *
 * @author houjing
 * @create 2019/5/27
 * @since 1.0.0
 */
@Service
public class MetroLineServiceImpl implements MetroLineService {

    @Resource
    private MetroStationDAO metroStationDAO;

    @Resource
    private MetroLineDAO metroLineDAO;

    @Resource
    private MetroRoutePlanDAO metroRoutePlanDAO;

    private static final int MAX_WEIGHT = 9999;

    private static int endPoints;

    private static Map<Long, Integer> stationNoInArray;

    private static Map<Integer, Long> stationNoMapping;

    private static String[] stationNameInArray;

    private static int[][] routeEdge;

    private static int[][] path;

    private static StringBuilder routePlan;


    @Override
    public List<MetroDisplayModel> generateLineInfo(List<MetroDisplayModel> metroLines) {
        LinkedHashMap<String, MetroDisplayModel> disorderMetroLineMap = new LinkedHashMap<>(metroLines.size());
        for (MetroDisplayModel metroLine : metroLines) {
            disorderMetroLineMap.put(metroLine.getStartStation(), metroLine);
        }

        MetroDisplayModel[] orderMetroArray = new MetroDisplayModel[metroLines.size()];
        int start = 0;
        int tail = 0;
        while (!disorderMetroLineMap.isEmpty()) {
            String key = disorderMetroLineMap.entrySet().iterator().next().getKey();
            MetroDisplayModel metroDisplayModel = disorderMetroLineMap.get(key);
            disorderMetroLineMap.remove(key);
            if (tail == 0 || orderMetroArray[tail - 1].getEndStation().equals(metroDisplayModel.getStartStation())) {
                orderMetroArray[tail] = metroDisplayModel;
                tail++;
            } else if (orderMetroArray[start].getStartStation().equals(metroDisplayModel.getEndStation())) {
                start = (start + orderMetroArray.length - 1) % orderMetroArray.length;
                orderMetroArray[start] = metroDisplayModel;
            } else {
                disorderMetroLineMap.put(key, metroDisplayModel);
            }
        }

        List<MetroDisplayModel> orderMetroLineList = new ArrayList<>();
        for (int i = 0; i < orderMetroArray.length; i++) {
            orderMetroLineList.add(orderMetroArray[start]);
            start = (start + 1) % orderMetroArray.length;
        }
        return orderMetroLineList;
    }

    @Override
    public String[] generateLineString(List<MetroDisplayModel> orderMetroLineList) {
        String[] orderMetroLine = new String[orderMetroLineList.size() + 1];
        int i = 0;
        for (MetroDisplayModel metroDisplayModel : orderMetroLineList) {
            orderMetroLine[i] = metroDisplayModel.getStartStation();
            if (i == orderMetroLineList.size() - 1) {
                orderMetroLine[i + 1] = metroDisplayModel.getEndStation();
            }
            i++;
        }
        return orderMetroLine;
    }


    @Override
    public void renovateLinePlan() {

        metroRoutePlanDAO.deleteAll();
        initStationInfo();
        initRouteInfo();
        floydWeight();

        MetroRoute metroRoute = new MetroRoute();
        for (int i = 0; i < endPoints; i++) {
            for (int j = 0; j < endPoints; j++) {
                if (i != j && routeEdge[i][j] != MAX_WEIGHT) {
                    routePlan = new StringBuilder();
                    metroRoute.setAmount(routeEdge[i][j]);
                    metroRoute.setBeginStationId(stationNoMapping.get(i));
                    metroRoute.setBeginStationName(stationNameInArray[i]);
                    metroRoute.setFinalStationId(stationNoMapping.get(j));
                    metroRoute.setFinalStationName(stationNameInArray[j]);
                    routePlan.append(stationNameInArray[i]).append(",");
                    getPathPoint(i, j);
                    routePlan.append(stationNameInArray[j]);
                    metroRoute.setRoutePlan(routePlan.toString());
                    metroRoutePlanDAO.insertOne(metroRoute);
                }
            }
        }

    }

    @Override
    public MetroRoute findByStationName(String beginStationName, String finalStationName) {
        return metroRoutePlanDAO.findByStationName(beginStationName,finalStationName);
    }

    @Override
    public MetroRoute findByStationNo(long beginStationNo, long finalStationNo) {
        return metroRoutePlanDAO.findByStationNo(beginStationNo,beginStationNo);
    }

    private void initRouteInfo() {
        routeEdge = new int[endPoints][endPoints];
        for (int i = 0; i < endPoints; i++) {
            for (int j = 0; j < endPoints; j++) {
                routeEdge[i][j] = MAX_WEIGHT;
            }
        }
        List<MetroLine> metroLines = metroLineDAO.findAll();
        for (MetroLine metroLine : metroLines) {
            routeEdge[stationNoInArray.get(metroLine.getStartStation())][stationNoInArray.get(metroLine.getEndStation())]
                    = metroLine.getLineWeight();
            routeEdge[stationNoInArray.get(metroLine.getEndStation())][stationNoInArray.get(metroLine.getStartStation())]
                    = metroLine.getLineWeight();
        }

        path = new int[endPoints][endPoints];
        for (int i = 0; i < endPoints; i++) {
            for (int j = 0; j < endPoints; j++) {
                path[i][j] = -1;
            }
        }
    }

    private void initStationInfo() {
        List<MetroStation> stations = metroStationDAO.findAll();
        endPoints = stations.size();
        stationNoInArray = new HashMap();
        stationNameInArray = new String[endPoints];
        stationNoMapping = new HashMap();
        MetroStation metroStation;
        for (int i = 0; i < endPoints; i++) {
            metroStation = stations.get(i);
            stationNameInArray[i] = metroStation.getStationName();
            stationNoInArray.put(metroStation.getStationNo(), i);
            stationNoMapping.put(i, metroStation.getStationNo());
        }
    }

    private void floydWeight() {
        for (int k = 0; k < endPoints; k++) {
            for (int i = 0; i < endPoints; i++) {
                for (int j = 0; j < endPoints; j++) {
                    if (routeEdge[i][j] > routeEdge[i][k] + routeEdge[k][j]) {
                        routeEdge[i][j] = routeEdge[i][k] + routeEdge[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
    }

    private static void getPathPoint(int i, int j) {
        int k;
        k = path[i][j];
        if (k == -1) return;
        getPathPoint(i, k);
        routePlan.append(stationNameInArray[k]).append(",");
        getPathPoint(k, j);
    }

}