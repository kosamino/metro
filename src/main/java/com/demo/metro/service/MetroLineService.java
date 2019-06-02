package com.demo.metro.service;

import com.demo.metro.domain.model.entity.MetroDisplayModel;
import com.demo.metro.domain.model.entity.MetroRoute;

import java.util.List;

public interface MetroLineService {

    List<MetroDisplayModel> generateLineInfo(List<MetroDisplayModel> metroLines);

    String[] generateLineString(List<MetroDisplayModel> orderMetroLineList);

    void renovateLinePlan();

    MetroRoute findByStationName(String beginStationName,String finalStationName);

    MetroRoute findByStationNo(long beginStationNo,long finalStationNo);
}
