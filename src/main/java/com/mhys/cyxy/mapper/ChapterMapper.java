package com.mhys.cyxy.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChapterMapper {
    List<Map<String, Object>> getDicMsg();
}
