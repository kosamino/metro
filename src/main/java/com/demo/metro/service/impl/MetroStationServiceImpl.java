/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MetroStationServiceImpl
 * Author:   houjing
 * Date:     2019/5/19 23:13
 * Description: Metro station maintenance service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.service.impl;

import com.demo.metro.domain.model.dao.MetroLineDAO;
import com.demo.metro.domain.model.dao.MetroStationDAO;
import com.demo.metro.domain.model.entity.MetroDisplayModel;
import com.demo.metro.domain.model.entity.MetroLine;
import com.demo.metro.domain.model.entity.MetroStation;
import com.demo.metro.service.MetroLineService;
import com.demo.metro.service.MetroStationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈Metro station maintenance service〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@Service
public class MetroStationServiceImpl implements MetroStationService {

    @Resource
    private MetroStationDAO metroStationDAO;

    @Resource
    private MetroLineDAO metroLineDAO;

    @Resource
    private MetroLineService metroLineService;

    @Override
    public List<Map> queryAllMetroLines() {

        List<Integer> lineNoList = metroLineDAO.getAllLineNo();
        List<Map> allMetroLines = new ArrayList<>();
        for (long lineNo:lineNoList){
            allMetroLines.add(queryMetroLineById(lineNo));
        }
        return allMetroLines;
    }

    @Override
    public Map queryMetroLineById(long lineNo) {
        List<MetroDisplayModel> metroLines = metroLineDAO.findByLineNo(lineNo);
        List<MetroDisplayModel> orderMetroLineList = metroLineService.generateLineInfo(metroLines);
        String[] orderMetroLine= metroLineService.generateLineString(orderMetroLineList);
        Map resultMap = new HashMap();
        resultMap.put("lineNo",lineNo);
        resultMap.put("metroLineSketch",orderMetroLine);
        resultMap.put("metroLineInfo",orderMetroLineList);
        return resultMap;
    }

    @Override
    public Map insertMetroLine(List<MetroDisplayModel> stationList) {
        MetroLine metroLine = null;
        int lineNo = metroLineDAO.getNextLineNo();
        for (MetroDisplayModel metroDisplayModel : stationList) {
            metroLine = new MetroLine();
            long startStationNo = metroStationDAO.findByName(metroDisplayModel.getStartStation());
            if (0 >= startStationNo) {
                MetroStation startMetroStation = new MetroStation();
                startMetroStation.setStationName(metroDisplayModel.getStartStation());
                metroStationDAO.insertOne(startMetroStation);
                startStationNo = startMetroStation.getStationNo();
            }

            long endStationNo = metroStationDAO.findByName(metroDisplayModel.getEndStation());
            if (0 >= endStationNo) {
                MetroStation endMetroStation = new MetroStation();
                endMetroStation.setStationName(metroDisplayModel.getEndStation());
                metroStationDAO.insertOne(endMetroStation);
                endStationNo = endMetroStation.getStationNo();

            }

            metroLine.setStartStation(startStationNo);
            metroLine.setEndStation(endStationNo);
            metroLine.setLineWeight(metroDisplayModel.getWeight());
            metroLine.setLineNo(lineNo);
            if (0 >= metroLineDAO.insertOne(metroLine)) {
                metroLineDAO.deleteByLineNo(lineNo);
            }
        }

        metroLineService.renovateLinePlan();
        return this.queryMetroLineById(lineNo);
    }

    @Override
    public Map insertMetroStation(MetroDisplayModel metroDisplayModel) {
        return null;
    }

    @Override
    public long deleteMetroLineById(long lineNo) {
        return 0;
    }

}