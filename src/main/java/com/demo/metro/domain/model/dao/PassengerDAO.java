/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PassengerDAO
 * Author:   houjing
 * Date:     2019/5/16 00:50
 * Description: passenger dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.dao;

import com.demo.metro.domain.model.entity.Passenger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈passenger dao〉
 *
 * @author houjing
 * @create 2019/5/16
 * @since 1.0.0
 */
@Mapper
public interface PassengerDAO {

    List<Passenger> findAll();

    Passenger findById(long passengerId);

    //也可以通过注解的方式写入SQL语句
    @Select("select passenger_id as passengerId," +
            "passenger_name as passengerName," +
            "passenger_sex as passengerSex," +
            "travel_card as travelCard," +
            "oneway_card as onewayCard" +
            " from tb_passenger where passenger_id = #{passengerId}")
    Passenger queryById(long passengerId);

    void insertOne(Passenger passenger);

    void updateById(Passenger passenger);

    void deleteById(long passengerId);

    void deleteTravelCard(long passengerId);
}