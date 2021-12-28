package com.example.Mapper;

import com.example.beans.HunterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HunterMapper {
    @Select("select HUNTER_ID, HUNTER_NAME from HUNTER_INFO")
    List<HunterInfo> queryHuntersInfo();
}
