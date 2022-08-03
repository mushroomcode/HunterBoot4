package com.example.Controller;

import com.example.Bean.HunterBean;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class hunterControllerWithAngularJs {

    @RequestMapping(value = "/index")
    public String indexSearch() {
        return "action";
    }

    @RequestMapping(value="/search", produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public HunterBean search(String personName) {
        HunterBean bean = new HunterBean();
        bean.setName(personName);
        bean.setAge(32);
        bean.setAddress("hefei");
        Set<Integer> set = new HashSet<>();
        List<Integer> rr = new ArrayList<>(set);
        return bean;
    }

    @RequestMapping(value = "")
    @ResponseBody
    public void temp(CloseableHttpResponse closeableHttpResponse) {

    }

}
