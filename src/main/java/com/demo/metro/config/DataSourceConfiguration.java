/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DataSourceConfiguration
 * Author:   houjing
 * Date:     2019/5/16 00:18
 * Description: dataSource configuration
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.config;

/**
 * 〈一句话功能简述〉<br> 
 * 〈dataSource configuration〉
 *
 * @author houjing
 * @create 2019/5/16
 * @since 1.0.0
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * springboot环境中，是先加载@Configuration的，再加载@ServletComponentScan
 * @Configuration和配置文件application.properties加载顺序是：
 * 先加载application.properties配置信息，再加载@Configuration配置信息。
 */
@Configuration
public class DataSourceConfiguration {
    // 环境，相当于导入了application.properties配置内容。
    @Autowired
    private Environment env;

    /**
     * <bean class="javax.sql.DataSource" id="dataSource" />
     * @return
     */
    @Bean(name="dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);           // 初始化提供的连接数
        dataSource.setMaxActive(20);            // 最大的连接数
        dataSource.setMinIdle(0);               // 数据库连接池的最小维持连接数
        dataSource.setMaxWait(60000);           //  等待连接获取的最大超时时间
        dataSource.setValidationQuery("SELECT 1");      //用什么语句测试连接有效性
        dataSource.setTestOnBorrow(false);              //在获取连接的时候是否测试连接有效性
        dataSource.setTestWhileIdle(true);              //在空闲的时候是否测试连接有效性
        dataSource.setPoolPreparedStatements(false);    //要不要设置池化的PreparedStatements
        return dataSource;
    }

}