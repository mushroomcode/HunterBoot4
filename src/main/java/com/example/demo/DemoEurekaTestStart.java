package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 使用 eureka 的启动注解，
 * 2021-07-19
 * xiaoguanyue
 */
@EnableEurekaServer
@SpringBootApplication
public class DemoEurekaTestStart {
    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaTestStart.class);
    }
}
