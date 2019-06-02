package com.demo.metro.service;

import com.demo.metro.domain.model.entity.TravelRecord;

import java.util.List;
import java.util.Map;

public interface TravelService {

    TravelRecord findById(long travelRecordId);

    List<TravelRecord> findByPassengerId(long passengerId);

    Map travel(Map travelPara);
}
