package com.zys.config;

import com.zys.myInterceptor.Interceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;


/*
 * springmvc.xml
 * */
//SpringMVC的配置类
@Configuration
@ComponentScan(value = "com.zys", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {org.springframework.stereotype.Controller.class})
}, useDefaultFilters = false)
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置静态资源不过滤
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    //配置视图解析器
    @Override  //视图解析器
    public void configureViewResolvers(
            ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/", ".html");
    }


    //    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义的拦截器
        Interceptor interceptor = new Interceptor();
        //添加拦截器
        registry.addInterceptor(interceptor)
                //添加需要拦截的路径
                .addPathPatterns("/*");
        //白名单
        // .excludePathPatterns("/admin/**");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 解决controller返回字符串中文乱码问题
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }
}
