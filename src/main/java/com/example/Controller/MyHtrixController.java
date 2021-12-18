package com.example.Controller;

import com.Beans.HunterInit;
import com.example.Services.HunterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHtrixController {

    @Autowired
    private HunterServiceImpl service;

    @Autowired
    public HunterInit hunterInit;

    @RequestMapping("/hunterCar")
    @ResponseBody
    public String reqHunterAnno() {
        service.getTheLogs("honda");
        return "honda!!";
    }

    @RequestMapping("/hunterAsync")
    @ResponseBody
    public String reqHunterAsyncAnno() {
        System.out.println("BEGIN TIME:" + System.currentTimeMillis());
        service.asyncSystemOut("Integra!!");
        return "Integra!!";
    }

    @RequestMapping("/hunterName")
    @ResponseBody
    public String getHunterName() {
        return hunterInit.getHunterServerName();
    }

}
