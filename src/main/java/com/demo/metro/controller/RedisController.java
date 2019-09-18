/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisController
 * Author:   houjing
 * Date:     2019/6/19 21:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.controller;

import com.demo.metro.utils.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author houjing
 * @create 2019/6/19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/redis")
public class RedisController {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisUtil redisUtil;

    //添加
    @PostMapping(value = "/add")
    public void saveRedis() {
        redisUtil.set("test-key2","test-value");
//        stringRedisTemplate.opsForValue().set("test-key", "test-value");
    }

    //获取
    @GetMapping(value = "/get")
    public String getRedis() {
        return redisUtil.get("test-key2").toString();
//        return stringRedisTemplate.opsForValue().get("test-key");
    }
}