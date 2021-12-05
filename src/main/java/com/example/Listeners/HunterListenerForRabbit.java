package com.example.Listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class HunterListenerForRabbit implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("  print of !  ");
    }
}
