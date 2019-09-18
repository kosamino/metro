package com.demo.metro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * @MapperScan 描述Mybatis提供的Mapper所在包的必要配置文件
 * 如果不引入此注解，也可以通过properties或者yml进行配置
 */
@SpringBootApplication
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
// @MapperScan("com.demo.metro.domain.model.dao")
/**
 * 放在resources下的配置文件都会编译到classpath下，而java下的代码文件也是编译到classpath下
 * 因此resources下的文件也可以直接放到java下，只不过不便于管理
 */
//public class Application {
public class Application implements TransactionManagementConfigurer {

    @Resource(name="txManager1")
    private PlatformTransactionManager txManager1;

//    // 创建事务管理器1
//    @Bean(name = "txManager1")
//    public PlatformTransactionManager txManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    // 创建事务管理器2
//    @Bean(name = "txManager2")
//    public PlatformTransactionManager txManager2(EntityManagerFactory factory) {
//        return new JpaTransactionManager(factory);
//    }
//
//    // 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return txManager1;
//    }
//
//    @Bean
//    public Object testBean() {
//        System.out.println(">>>>>>>>>>" + txManager1.getClass().getName());
//        return new Object();
//    }

    // 其中 dataSource 框架会自动为我们注入
    @Bean(name = "txManager1")
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager1;
    }

    @Bean
    public Object testBean() {
        System.out.println(">>>>>>>>>>" + txManager1.getClass().getName());
        return new Object();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
