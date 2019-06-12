/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ChargeServiceImpl
 * Author:   houjing
 * Date:     2019/5/28 09:24
 * Description: buy or charge a card
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.service.impl;

import com.demo.metro.domain.model.dao.FeesRecordDAO;
import com.demo.metro.domain.model.dao.OnewayCardDAO;
import com.demo.metro.domain.model.dao.PassengerDAO;
import com.demo.metro.domain.model.dao.TravelCardDAO;
import com.demo.metro.domain.model.entity.FeesRecord;
import com.demo.metro.domain.model.entity.OnewayCard;
import com.demo.metro.domain.model.entity.Passenger;
import com.demo.metro.domain.model.entity.TravelCard;
import com.demo.metro.service.ChargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈buy or charge a card〉
 *
 * @author houjing
 * @create 2019/5/28
 * @since 1.0.0
 */
@Service
public class ChargeServiceImpl implements ChargeService {

    @Resource
    private PassengerDAO passengerDAO;

    @Resource
    private OnewayCardDAO onewayCardDAO;

    @Resource
    private TravelCardDAO travelCardDAO;

    @Resource
    private FeesRecordDAO feesRecordDAO;

    @Override
    public OnewayCard buyOnewayCard(long passengerId, long amount) {
        OnewayCard onewayCard = null;
        if (passengerId != 0 && amount != 0) {
            onewayCard = new OnewayCard();
            onewayCard.setAmount(amount);
            onewayCard.setPassengerId(passengerId);
            onewayCardDAO.insertOne(onewayCard);
            long onewayCardNo = onewayCard.getOnewayCardNo();
            Passenger passenger = new Passenger();
            passenger.setOnewayCard(onewayCardNo);
            passenger.setPassengerId(passengerId);
            passengerDAO.updateById(passenger);
        }
        return onewayCard;
    }

    @Override
    public TravelCard buyTravelCard(long passengerId, long amount) {
        TravelCard travelCard = null;
        if (passengerId != 0 && amount != 0) {
            travelCard = new TravelCard();
            travelCard.setRemainder(amount);
            travelCard.setPassengerId(passengerId);
            travelCardDAO.insertOne(travelCard);

            long travelCardNo = travelCard.getTravelCardNo();
            Passenger passenger = new Passenger();
            passenger.setTravelCard(travelCardNo);
            passenger.setPassengerId(passengerId);
            passengerDAO.updateById(passenger);

            FeesRecord feesRecord = new FeesRecord();
            feesRecord.setAmount(amount);
            feesRecord.setOperationType(0);
            feesRecord.setTravelCard(travelCardNo);
            feesRecordDAO.insertOne(feesRecord);
        }
        return travelCard;
    }

    @Override
    public TravelCard chargeTravelCard(long passengerId, long amount) {
        TravelCard travelCard = null;
        if (passengerId != 0 && amount != 0) {
            Passenger passenger = passengerDAO.findById(passengerId);
            if (passenger.getTravelCard() > 0) {
                travelCard = travelCardDAO.findById(passenger.getTravelCard());
                travelCard.setRemainder(travelCard.getRemainder() + amount);
                travelCardDAO.updateById(travelCard);

                FeesRecord feesRecord = new FeesRecord();
                feesRecord.setAmount(amount);
                feesRecord.setOperationType(1);
                feesRecord.setTravelCard(travelCard.getTravelCardNo());
                feesRecordDAO.insertOne(feesRecord);
            }
        }
        return travelCard;
    }

    @Override
    public TravelCard deleteTravelCard(long passengerId) {
        if (passengerId != 0) {
            long travelCard = passengerDAO.findById(passengerId).getTravelCard();
            if (travelCard > 0) {
                passengerDAO.deleteTravelCard(passengerId);
                return travelCardDAO.findById(travelCard);
            }
        }
        return null;
    }

    @Override
    public Map getCards(long passengerId) {
        Map cards = null;
        if (passengerId != 0) {
            cards = new HashMap();
            Passenger passenger = passengerDAO.findById(passengerId);
            if (passenger.getOnewayCard() >= 0) {
                cards.put("onewayCard", onewayCardDAO.findById(passenger.getOnewayCard()));
            }
            if (passenger.getTravelCard() >= 0) {
                cards.put("travelCard", travelCardDAO.findById(passenger.getTravelCard()));
            }
        }

        return cards;
    }
}