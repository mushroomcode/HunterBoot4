package com.example.Services;

import com.example.annotations.HunterAsyncAnno;
import com.example.annotations.HunterLogAnno;
import org.springframework.stereotype.Service;

@Service
public class HunterServiceImpl {

    @HunterLogAnno(value = "honda")
    public void getTheLogs(String name) {
        System.out.println(name);
    }

    @HunterAsyncAnno
    public void asyncSystemOut(String name) {
        System.out.println("This text loggout in 5s!!");
    }

}
