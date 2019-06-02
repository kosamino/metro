/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MetroRoutePlanDAO
 * Author:   houjing
 * Date:     2019/5/27 01:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.dao;

import com.demo.metro.domain.model.entity.MetroRoute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author houjing
 * @create 2019/5/27
 * @since 1.0.0
 */
@Mapper
public interface MetroRoutePlanDAO {

    List<MetroRoute> findAll();

    MetroRoute findByStationName(String beginStationName,String finalStationName);

    void insertOne(MetroRoute metroRoute);

    void deleteAll();

    MetroRoute findByStationNo(long beginStationNo, long beginStationNo1);
}