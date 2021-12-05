package com.example.Configuration;

public class RateLimited {

    private RateLimited() {}

    private static volatile RateLimited instance;

    public static RateLimited getInstance () throws Exception {
        if(instance == null) {
            synchronized (RateLimited.class) {
                if(instance == null) {
                    instance = new RateLimited();
                }
            }
        }
        return instance;
    }

}
