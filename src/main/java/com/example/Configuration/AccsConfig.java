package com.example.Configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccsConfig implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            Resource[] resources = applicationContext.getResources(
                    "classpath:*");
            System.out.println(resources.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
