/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TravelServiceImpl
 * Author:   houjing
 * Date:     2019/5/30 09:41
 * Description: travel service impl
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.service.impl;

import com.demo.metro.domain.model.dao.*;
import com.demo.metro.domain.model.entity.*;
import com.demo.metro.service.TravelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈travel service impl〉
 *
 * @author houjing
 * @create 2019/5/30
 * @since 1.0.0
 */
@Service
public class TravelServiceImpl implements TravelService {

    @Resource
    private PassengerDAO passengerDAO;

    @Resource
    private TravelCardDAO travelCardDAO;

    @Resource
    private OnewayCardDAO onewayCardDAO;

    @Resource
    private FeesRecordDAO feesRecordDAO;

    @Resource
    private TravelRecordDAO travelRecordDAO;

    @Resource
    private MetroRoutePlanDAO metroRoutePlanDAO;

    @Resource
    private MetroStationDAO metroStationDAO;

    @Resource
    private BlackListDAO blackListDAO;


    @Override
    public List<TravelRecord> findByPassengerId(long passengerId) {
        return travelRecordDAO.findByPassengerId(passengerId);
    }

    @Override
    public TravelRecord findById(long travelRecordId) {
        return travelRecordDAO.findById(travelRecordId);
    }

    @Override
    public Map travel(Map travelPara) {
        Map resultMap = new HashMap();
        resultMap.put("failFlag", 1);
        long passengerId = (long) travelPara.get("passengerId");
        int cardType = (Integer) travelPara.get("cardType");
        Passenger passenger = null;
        long travelCardNo = 0;
        long onewayCardNo = 0;
        if (passengerId > 0) {
            List<BlackList> blackRecords = blackListDAO.findById(passengerId);
            if (blackRecords != null && blackRecords.size() > 3) {
                resultMap.put("FailMsg", "Too much blackList Records, please clean it before the traveling.");
                return resultMap;
            }

            passenger = passengerDAO.findById(passengerId);
            if (cardType == 0) {
                if (passenger.getTravelCard() == 0) {
                    resultMap.put("FailMsg", "No travelCard matched, please purchase the travel card.");
                    return resultMap;
                } else {
                    travelCardNo = passenger.getTravelCard();
                }

            } else if (cardType == 1) {
                if (passenger.getOnewayCard() == 0) {
                    resultMap.put("FailMsg", "No one-way Card matched, please purchase the one-way card.");
                    return resultMap;
                } else {
                    onewayCardNo = passenger.getOnewayCard();
                }
            } else {
                resultMap.put("FailMsg", "Please choose a card to pay for the fees.");
                return resultMap;
            }
        }
        if (passengerId == 0 || passenger == null) {
            resultMap.put("FailMsg", "Please confirm the passenger information.");
            return resultMap;
        }

        long startStationNo = (long) travelPara.get("startStation");
        long endStationNo = (long) travelPara.get("endStation");
        if (startStationNo == 0 || metroStationDAO.findById(startStationNo) == null) {
            resultMap.put("FailMsg", "The startStation is not exist.");
            return resultMap;
        }
        if (endStationNo == 0 || metroStationDAO.findById(endStationNo) == null) {
            resultMap.put("FailMsg", "The endStation is not exist.");
            return resultMap;
        }
        MetroRoute metroRoute = new MetroRoute();
        metroRoute.setBeginStationId(startStationNo);
        metroRoute.setFinalStationId(endStationNo);
        metroRoute = metroRoutePlanDAO.findByStationNo(metroRoute);
        if (metroRoute == null) {
            resultMap.put("FailMsg", "There is no route from startStation to  endStation, please confirm the Route.");
            return resultMap;
        }


        if (cardType == 0) {
            TravelCard travelCard = travelCardDAO.findById(travelCardNo);
            long realFees = travelCard.getRemainder() < metroRoute.getAmount() ? travelCard.getRemainder() : metroRoute.getAmount();

            FeesRecord feesRecord = new FeesRecord();
            feesRecord.setTravelCard(travelCardNo);
            //0,购卡;1,充值;2,消费
            feesRecord.setOperationType(2);
            feesRecord.setAmount(realFees);
            feesRecordDAO.insertOne(feesRecord);

            TravelRecord travelRecord = new TravelRecord();
            travelRecord.setPassengerId(passengerId);
            travelRecord.setAmount(realFees);
            travelRecord.setBeginStationId(startStationNo);
            travelRecord.setFinalStationId(endStationNo);
            travelRecord.setTravelCard(travelCardNo);
            travelRecord.setTravelInfo(metroRoute.getRoutePlan());
            travelRecordDAO.insertOne(travelRecord);

            if (travelCard.getRemainder() < metroRoute.getAmount()) {
                resultMap.put("FailMsg", ".There is no enough money, blacklist recorded, please charge.");
                BlackList blackList = new BlackList();
                blackList.setTravelRecordId(travelRecord.getTravelRecordId());
                blackList.setPassengerId(passengerId);
                blackListDAO.insertOne(blackList);
            }

            travelCard.setRemainder(travelCard.getRemainder() - realFees);
            travelCardDAO.updateById(travelCard);
        } else {
            OnewayCard onewayCard = onewayCardDAO.findById(onewayCardNo);
            long realFees = onewayCard.getAmount();
            passenger.setOnewayCard(0);
            passengerDAO.updateById(passenger);
            onewayCard.setUsageFlag(1);
            onewayCard.setExpireTime(new Timestamp(new Date().getTime()));
            onewayCardDAO.updateById(onewayCard);

            TravelRecord travelRecord = new TravelRecord();
            travelRecord.setAmount(realFees);
            travelRecord.setBeginStationId(startStationNo);
            travelRecord.setFinalStationId(endStationNo);
            travelRecord.setOnewayCard(onewayCardNo);
            travelRecord.setTravelInfo(metroRoute.getRoutePlan());
            travelRecordDAO.insertOne(travelRecord);

            if (onewayCard.getAmount() < metroRoute.getAmount()) {
                resultMap.put("FailMsg", ".There one-way card have no enough money, blacklist recorded.");
                BlackList blackList = new BlackList();
                blackList.setTravelRecordId(travelRecord.getTravelRecordId());
                blackList.setPassengerId(passengerId);
                blackListDAO.insertOne(blackList);
            }
        }
        resultMap.put("failFlag", 0);
        return resultMap;
    }
}