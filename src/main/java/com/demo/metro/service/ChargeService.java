package com.demo.metro.service;

import com.demo.metro.domain.model.entity.OnewayCard;
import com.demo.metro.domain.model.entity.TravelCard;

import java.util.Map;

public interface ChargeService {

    OnewayCard buyOnewayCard(long passengerId, long amount);

    TravelCard buyTravelCard(long passengerId, long amount);

    TravelCard chargeTravelCard(long passengerId, long amount);

    TravelCard deleteTravelCard(long passengerId);

    Map getCards(long passengerId);

}
