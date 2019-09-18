/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ChargeController
 * Author:   houjing
 * Date:     2019/5/28 09:21
 * Description: charging for card
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.controller;

import com.demo.metro.domain.model.entity.OnewayCard;
import com.demo.metro.domain.model.entity.TravelCard;
import com.demo.metro.service.ChargeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈charging for card〉
 *
 * @author houjing
 * @create 2019/5/28
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/metro")
public class ChargeController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PassengerController.class);

    //@Resource 和@Autowired 什么区别
    @Resource
    private ChargeService chargeService;

    /**
     * 购买单程卡
     *
     * @param amount
     */
    @RequestMapping(value = {"/onewaycard"}, method = RequestMethod.POST)
    public OnewayCard buyOnewayCard(@RequestParam("passengerId") long passengerId,
                                    @RequestParam("amount") long amount) {
        LOGGER.info("Create a request for buyOnewayCard(POST).");
        return this.chargeService.buyOnewayCard(passengerId, amount);
    }

    /**
     * 购买交通卡并充值
     *
     * @param amount
     */
    @RequestMapping(value = {"/travelcard"}, method = RequestMethod.POST)
    public TravelCard buyTravelCard(@RequestParam("passengerId") long passengerId,
                                    @RequestParam("amount") long amount) {
        LOGGER.info("Create a request for buyTravelCard(POST).");
        return this.chargeService.buyTravelCard(passengerId, amount);
    }

    /**
     * 交通卡充值
     *
     * @param amount
     */
    @RequestMapping(value = {"/travelcard"}, method = RequestMethod.PUT)
    public TravelCard chargeTravelCard(@RequestParam("passengerId") long passengerId,
                                       @RequestParam("amount") long amount) {
        LOGGER.info("Create a request for buyTravelCard(POST).");
        return this.chargeService.chargeTravelCard(passengerId, amount);
    }

    /**
     * 注销交通卡
     *
     * @param passengerId
     */
    @RequestMapping(value = {"/travelcard/{passengerId}"}, method = RequestMethod.DELETE)
    public TravelCard deleteTravelCard(@PathVariable("passengerId") long passengerId) {
        LOGGER.info("Create a request for deleteTravelCard(DELETE).");
        return this.chargeService.deleteTravelCard(passengerId);
    }

    /**
     * 查询名下交通卡以及单程卡
     *
     * @param passengerId
     */
    @RequestMapping(value = {"/cards/{passengerId}"}, method = RequestMethod.GET)
    public Map getCards(@PathVariable("passengerId") long passengerId) {
        LOGGER.info("Create a request for getCards(GET).");
        return this.chargeService.getCards(passengerId);
    }

}