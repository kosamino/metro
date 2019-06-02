/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MetroStationDAO
 * Author:   houjing
 * Date:     2019/5/19 15:39
 * Description: metro  station dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.dao;

import com.demo.metro.domain.model.entity.MetroStation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈metro  station dao〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@Mapper
public interface MetroStationDAO {

    List<MetroStation> findAll();

    MetroStation findById(long stationNo);

    long insertOne(MetroStation metroStation);

    void updateById(MetroStation metroStation);

    void deleteById(long stationNo);

    long findByName(String stationName);

    long countStations();
}