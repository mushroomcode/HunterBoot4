package com.example.Controller;

import com.example.Services.HunterServiceImpl;
import com.example.annotations.HunterLogAnno;
import com.example.annotations.MytrixAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MyHtrixController {

    private Random random = new Random();

    @Autowired
    private HunterServiceImpl service;

    @MytrixAnno(fallback = "errorMethod")
    @RequestMapping("/hello")
    public String resolveRest(@RequestParam("name") String message) {
        int time = random.nextInt(200);
        System.out.println();
        return "hello world:" + message;
    }

    @RequestMapping("/hunterCook")
    @ResponseBody
    public String reqHunterAnno() {
        service.getTheLogs("Integra!!");
        return "Integra!!";
    }

}
