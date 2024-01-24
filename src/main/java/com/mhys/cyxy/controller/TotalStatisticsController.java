package com.mhys.cyxy.controller;

import com.alibaba.fastjson2.JSONObject;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.service.ITotalStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class TotalStatisticsController {

    @Autowired
    private ITotalStatisticsService totalStatisticsService;

    @RequestMapping("/getTotalStatistics")
    @ResponseBody
    public Map<String, Object> getTotalStatistics() {
        return totalStatisticsService.getTotalStatistics();
    }

    @RequestMapping("/getDicMsg")
    @ResponseBody
    public JSONObject getDicMsg(){
        return totalStatisticsService.getDicMsg();
    }
}
