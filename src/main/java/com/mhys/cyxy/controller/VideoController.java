package com.mhys.cyxy.controller;

import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.vo.VideoVO;
import com.mhys.cyxy.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@Controller
public class VideoController {

    private final int VIDEO_DAY_RANGE = 7;

    @Autowired
    private IVideoService videoService;

    @ResponseBody
    @RequestMapping("/getAllVideoRate")
    public VideoVO getAllVideoRate(@RequestParam(value = "beginTime",required = false) LocalDate beginTime,@RequestParam(value = "endTime",required = false) LocalDate endTime){
        if(beginTime == null){
            beginTime = LocalDate.now().minusDays(VIDEO_DAY_RANGE);
        }
        if (endTime == null){
            endTime = LocalDate.now();
        }
        VideoVO vo = videoService.getAllVideoRate(beginTime, endTime);
        return  vo;
    }

    @ResponseBody
    @RequestMapping("/getVideoRateByGrade")
    public List<VideoVO> getVideoRateByGrade(@RequestParam(value = "beginTime",required = false) LocalDate beginTime, @RequestParam(value = "endTime",required = false) LocalDate endTime){
        if(beginTime == null){
            beginTime = LocalDate.now().minusDays(VIDEO_DAY_RANGE);
        }
        if (endTime == null){
            endTime = LocalDate.now();
        }
        List<VideoVO> list = videoService.getVideoRateByGrade(beginTime, endTime);
        list.stream().forEach(item->item.setVideoDayRange(VIDEO_DAY_RANGE));
        return list;
    }

    @ResponseBody
    @RequestMapping("/getVideoRateByCourse")
    public List<VideoVO> getVideoRateByCourse(@RequestParam(value = "gradeId",required = true) int gradeId){
        List<VideoVO> list = videoService.getVideoRateByCourse(gradeId);
        list.stream().forEach(item->item.setVideoDayRange(VIDEO_DAY_RANGE));
        return list;
    }
}
