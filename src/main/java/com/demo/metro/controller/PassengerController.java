/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PassengerController
 * Author:   houjing
 * Date:     2019/5/16 01:38
 * Description: passenger controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.controller;

import com.demo.metro.domain.model.entity.Passenger;
import com.demo.metro.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈passenger controller〉
 *
 * @author houjing
 * @create 2019/5/16
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/metro")
public class PassengerController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PassengerController.class);

    //@Resource 和@Autowired 什么区别
    @Resource
    private PassengerService passengerService;

    /**
     * 查询所有乘客信息
     * @return List<Passenger>
     */
    @RequestMapping(value = {"/passengers"}, method = RequestMethod.GET)
    public List<Passenger> queryPassengers(){
        LOGGER.info("Get a request for queryPassengers(GET).");
        return this.passengerService.findAll();
    }

    /**
     * 根据passengerId查询乘客信息
     * @return Passenger
     */
    @RequestMapping(value = {"/passenger/{passengerId}"}, method = RequestMethod.GET)
    public Passenger queryPassengerById(@PathVariable("passengerId") long passengerId) {
        LOGGER.info("Get a request for queryPassengerById(GET).");
        return this.passengerService.findById(passengerId);
    }

    /**
     * 录入乘客信息
     * @param passenger
     * @return long
     */
    @RequestMapping(value = {"/passenger"}, method = RequestMethod.POST)
    public long insertOne(@RequestBody Passenger passenger) {
        LOGGER.info("Get a request for insertPassenger(POST).");
        return this.passengerService.insertOne(passenger);
    }

    /**
     * 修改乘客信息
     * @param passenger
     */
    @RequestMapping(value = {"/passenger"}, method = RequestMethod.PUT)
    public void updatePassenger(@RequestBody Passenger passenger) {
        LOGGER.info("Get a request for updatePassenger(PUT).");
        this.passengerService.updateById(passenger);
    }

    /**
     * 删除乘客信息
     * @param passengerId
     */
    @RequestMapping(value = {"/passenger/{passengerId}"}, method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("passengerId") long passengerId) {
        LOGGER.info("Get a request for deletePassengerById(DELETE).");
        this.passengerService.deleteById(passengerId);
    }
}