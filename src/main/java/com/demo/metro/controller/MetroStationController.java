/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MetroStationController
 * Author:   houjing
 * Date:     2019/5/19 23:06
 * Description: metro station maintenance controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.controller;

import com.demo.metro.domain.model.entity.MetroDisplayModel;
import com.demo.metro.service.MetroStationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈metro station maintenance controller〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/metro")
public class MetroStationController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PassengerController.class);

    //@Resource 和@Autowired 什么区别
    @Resource
    private MetroStationService metroStationService;

    /**
     * 查询所有地铁线路信息
     * @return JsonArray
     */
    @RequestMapping(value = {"/metrolines"}, method = RequestMethod.GET)
    public List queryAllMetroLines() {
        LOGGER.info("Get a request for metroLines(GET).");
        return this.metroStationService.queryAllMetroLines();
    }

    /**N
     * 根据线路Id查询地铁线路信息
     * @param lineNo
     * @return JsonNode
     */
    @RequestMapping(value = {"/metroline/{lineNo}"}, method = RequestMethod.GET)
    public Map queryMetroLineById(@PathVariable("lineNo") long lineNo) {
        LOGGER.info("Get a request for queryMetroLineById(GET).");
        return this.metroStationService.queryMetroLineById(lineNo);
    }

    /**
     * 批量新增线路信息
     * @param stationList
     * @return JsonNode
     */
    @RequestMapping(value = {"/metroline"}, method = RequestMethod.POST)
    public Map insertMetroLine(@RequestBody List<MetroDisplayModel> stationList) {
        LOGGER.info("Get a request for insertMetroLine(POST).");
        return this.metroStationService.insertMetroLine(stationList);
    }

    /**
     * 新增单个站点信息
     * @param metroDisplayModel
     * @return JsonNode
     */
    @RequestMapping(value = {"/metrostation"}, method = RequestMethod.PUT)
    public Map insertMetroStation(@RequestBody MetroDisplayModel metroDisplayModel) {
        LOGGER.info("Get a request for insertMetroStation(PUT).");
        return this.metroStationService.insertMetroStation(metroDisplayModel);
    }

    /**
     * 删除线路信息
     * @param lineNo
     * @return JsonNode
     */
    @RequestMapping(value = {"/passenger/{lineNo}"}, method = RequestMethod.DELETE)
    public long deleteMetroLineById(@PathVariable("lineNo") long lineNo) {
        LOGGER.info("Get a request for deleteMetroLineById(DELETE).");
        return this.metroStationService.deleteMetroLineById(lineNo);
    }

}