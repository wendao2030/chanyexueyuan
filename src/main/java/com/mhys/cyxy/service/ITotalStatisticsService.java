package com.mhys.cyxy.service;

import com.alibaba.fastjson2.JSONObject;

import java.util.List;
import java.util.Map;

public interface ITotalStatisticsService {
    Map<String, Object> getTotalStatistics() throws Exception;
    JSONObject getDicMsg() throws Exception;
}
