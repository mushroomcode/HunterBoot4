package com.example.demo;

import com.example.Listeners.HunterListenerForFox;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 使用 eureka 的启动注解，服务的注册中心
 * 2021-07-19
 * xiaoguanyue
 */
//@EnableEurekaServer
@ServletComponentScan(basePackages = "com.example.Listeners")
@SpringBootApplication
public class DemoEurekaTestStart {
    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaTestStart.class, args);
    }

//    @Bean
//    public RouteLocator getRouteService(RouteLocatorBuilder builder) {
//        return builder.routes().route("path_route", r -> r.path("/helloS")
//                .uri("https://www.baidu.com/")).build();
//    }

//    @Bean
//    public ServletRegistrationBean getListener() {
//        return ;
//    }

}
