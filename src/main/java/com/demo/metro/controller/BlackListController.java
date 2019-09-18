/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BlackListController
 * Author:   houjing
 * Date:     2019/6/14 09:29
 * Description: blacklist controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.controller;

import com.demo.metro.domain.model.entity.BlackListInfo;
import com.demo.metro.service.BlackListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈blacklist controller〉
 *
 * @author houjing
 * @create 2019/6/14
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/metro")
public class BlackListController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PassengerController.class);

    //@Resource 和@Autowired 什么区别
    @Resource
    private BlackListService blackListService;

    /**
     * 查询所有黑名单信息
     * @return List<BlackListInfo>
     */
    @RequestMapping(value = {"/blackList"}, method = RequestMethod.GET)
    public List<BlackListInfo> queryBlackList(){
        LOGGER.info("Get a request for queryBlackList(GET).");
        return this.blackListService.findAll();
    }

}