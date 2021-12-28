package com.example.Services;

import com.example.Mapper.HunterMapper;
import com.example.beans.HunterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HunterDataServices {

    @Autowired
    private HunterMapper mapper;

    public List<HunterInfo> queryHuntersInfo() {
        return mapper.queryHuntersInfo();
    }
}
