package com.example.Listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HunterListenerForFox implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Destroy......!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener....init....!");
    }
}
