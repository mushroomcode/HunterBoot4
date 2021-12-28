package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 使用 eureka 的启动注解，服务的注册中心
 * 2021-07-19
 * xiaoguanyue
 */
//@EnableEurekaServer
//@ServletComponentScan(basePackages = "com.example.*")
@SpringBootApplication
@EnableAspectJAutoProxy
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
