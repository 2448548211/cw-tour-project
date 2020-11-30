package com.clever.chen.app;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ChenWang
 * @className GroupTourApp
 * @date 2020/11/27 11:55
 * @since JDK 1.8
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class GroupTourApp {
    public static void main(String[] args) {
        SpringApplication.run(GroupTourApp.class,args);
    }
}
