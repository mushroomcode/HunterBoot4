package com.example.Controller;

import com.example.annotations.MytrixAnno;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

public class MyHtrixController {

    private Random random = new Random();

    @MytrixAnno(fallback = "errorMethod")
    @RequestMapping("/hello")
    public String resolveRest(@RequestParam("name") String message) {
        int time = random.nextInt(200);
        System.out.println();
        return "hello world:" + message;
    }

}
