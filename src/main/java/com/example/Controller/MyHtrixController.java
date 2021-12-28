package com.example.Controller;

import com.Beans.HunterInit;
import com.HunterProperties.HunterDataConfigProperties;
import com.example.Configuration.AutoBeanConfiguration;
import com.example.Services.HunterDataServices;
import com.example.Services.HunterServiceImpl;
import com.example.beans.HunterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
public class MyHtrixController {

    @Autowired
    private HunterServiceImpl service;

    @Autowired
    private HunterDataServices dataServices;

    @Autowired

    private HunterDataConfigProperties properties;

    @Autowired
    public AutoBeanConfiguration autoBeanConfiguration;

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
//
    @RequestMapping("/hunterName")
    @ResponseBody
    public List<HunterInfo> getHunterName() throws SQLException {
//        return hunterInit.getHunterServerName();
        return dataServices.queryHuntersInfo();
    }

    @RequestMapping("/hunterExcel")
    @ResponseBody
    public int getHunterExcelResource() {
        return autoBeanConfiguration.getCorePoolSize();
    }


}
