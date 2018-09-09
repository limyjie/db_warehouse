
package com.lg.warehouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;






//拦截register，
//extends WebMvcConfigurationSupport

@SpringBootConfiguration
public class MySpringMVCConfig  implements WebMvcConfigurer {

    @Autowired
    UserLoginInterceptorBySpring userLoginInterceptorBySpring;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginInterceptorBySpring)
                .addPathPatterns("/addGoods")
                .addPathPatterns("/addOrder")
                .addPathPatterns("/addWarehouse")
                .addPathPatterns("/allOrder")
                .addPathPatterns("/deleteOrder")
                .addPathPatterns("/dispatch")
                .addPathPatterns("/finishedOrder")
                .addPathPatterns("/index")
                .addPathPatterns("/navigation")
                .addPathPatterns("/OrderByID")
                .addPathPatterns("/queryAllGoods")
                .addPathPatterns("/queryWarehouse")
                .addPathPatterns("/navigation#")
                .addPathPatterns("/unfinishedOrder");

    }
}

