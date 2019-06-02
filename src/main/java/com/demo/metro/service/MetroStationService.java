package com.demo.metro.service;

import com.demo.metro.domain.model.entity.MetroDisplayModel;

import java.util.List;
import java.util.Map;

public interface MetroStationService {

    List<Map> queryAllMetroLines();

    Map queryMetroLineById(long lineNo);

    Map insertMetroLine(List<MetroDisplayModel> stationList);

    Map insertMetroStation(MetroDisplayModel metroDisplayModel);

    long deleteMetroLineById(long lineNo);
}