package com.clever.chen.app.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author ChenWang
 * @date 2020/11/27 14:42
 * @since JDK 1.8
 */
@Configuration
@MapperScan("com.clever.chen.app.mapper")
public class MybatisPlusConfig {
    /**
     * 注册分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        /* 是否处理溢出的分页页码请求 */
        paginationInterceptor.setOverflow(true);
        /* 最大分页数据数目 */
        paginationInterceptor.setLimit(100L);
        return paginationInterceptor;
    }
}
