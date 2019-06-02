/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestDataSource
 * Author:   houjing
 * Date:     2019/5/15 01:48
 * Description: test dataSource
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.controller;

import com.demo.metro.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test dataSource〉
 *
 * @author houjing
 * @create 2019/5/15
 * @since 1.0.0
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestDataSource {
    @Resource
    private DataSource dataSource;
    @Test
    public void testConnection() throws Exception {
        System.out.println(this.dataSource);
    }
}