/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TravelController
 * Author:   houjing
 * Date:     2019/5/30 09:21
 * Description: passenger travel controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.controller;

import com.demo.metro.domain.model.entity.TravelRecord;
import com.demo.metro.service.TravelService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈passenger travel controller〉
 *
 * @author houjing
 * @create 2019/5/30
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/metro")
public class TravelController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PassengerController.class);

    //@Resource 和@Autowired 什么区别
    @Resource
    private TravelService travelService;

    /**
     * 根据passengerId查询出行记录信息
     * @param passengerId
     * @return List
     */
    @RequestMapping(value = {"/travel/{passengerId}"}, method = RequestMethod.GET)
    public List<TravelRecord> queryTravelRecords(@PathVariable("passengerId") long passengerId) {
        LOGGER.info("Get a request for queryTravelRecords(GET).");
        return this.travelService.findByPassengerId(passengerId);
    }

    /**
     * 用户出行
     * @param passengerId
     * @param startStation
     * @param endStation
     * @param cardType
     * @return TravelRecord
     */
    @RequestMapping(value = {"/travel"}, method = RequestMethod.POST)
    public Map travel(@PathVariable long passengerId,
                       @PathVariable long startStation,
                       @PathVariable long endStation,
                       @PathVariable int cardType) {
        LOGGER.info("Begin a travel trip(POST).");
        Map travelPara = new HashMap();
        travelPara.put("passengerId",passengerId);
        travelPara.put("startStation",startStation);
        travelPara.put("endStation",endStation);
        travelPara.put("cardType",cardType);
        return this.travelService.travel(travelPara);
    }

}