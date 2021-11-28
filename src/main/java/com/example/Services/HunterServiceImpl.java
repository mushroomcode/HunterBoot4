package com.example.Services;

import com.example.annotations.HunterLogAnno;
import org.springframework.stereotype.Service;

@Service
public class HunterServiceImpl {

    @HunterLogAnno(value = "Integra")
    public void getTheLogs(String name) {
        System.out.println(name);
    }

}
