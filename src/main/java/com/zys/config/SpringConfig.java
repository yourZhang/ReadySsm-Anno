package com.zys.config;

import com.zys.exceptionResolver.MyHandlerExceptionResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: ssm
 * @description: springConfig
 * @author: xiaozhang6666
 * @create: 2020-09-14 16:48
 **/
@Configuration
@Import({MyBatisConfig.class,SpringServiceConfig.class})
public class SpringConfig {
    //自定义异常处理器
    @Bean
    public MyHandlerExceptionResolver myHandlerExceptionResolver() {
        MyHandlerExceptionResolver myHandlerExceptionResolver = new MyHandlerExceptionResolver();
        return myHandlerExceptionResolver;
    }
}
