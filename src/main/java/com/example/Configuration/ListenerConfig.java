package com.example.Configuration;

import com.example.Listeners.HunterAppListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
    @Bean
    public ApplicationListener applicationStartListener() {
        return new HunterAppListener();
    }
}
