package com.mhys.cyxy.controller;

import com.alibaba.fastjson2.JSONObject;
import com.mhys.cyxy.domain.ResponseData;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.VideoVO;
import com.mhys.cyxy.service.ITotalStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class TotalStatisticsController {

    @Autowired
    private ITotalStatisticsService totalStatisticsService;

    @RequestMapping("/getTotalStatistics")
    @ResponseBody
    public ResponseData<Map<String, Object>> getTotalStatistics(){
        try {
            Map<String, Object> map = totalStatisticsService.getTotalStatistics();
            log.info("查询综合统计信息成功");
            return new ResponseData<>(map);
        }catch (Exception e){
            log.error("查询综合统计信息失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }

    }

    @RequestMapping("/getDicMsg")
    @ResponseBody
    public ResponseData<JSONObject> getDicMsg(){
        try {
            JSONObject jsObject = totalStatisticsService.getDicMsg();
            log.info("查询字典信息成功");
            return new ResponseData<>(jsObject);
        }catch (Exception e){
            log.error("查询字典信息失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }
}
