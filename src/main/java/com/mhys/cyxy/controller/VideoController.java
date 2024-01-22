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
@RequestMapping("/liuzhi")
public class VideoController {

    @Autowired
    private IVideoService videoService;

    @ResponseBody
    @RequestMapping("/getAllVideoRate")
    public VideoVO getAllVideoRate(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId){
        VideoVO vo = videoService.getAllVideoRate(termId, weekId);
        return  vo;
    }

    @ResponseBody
    @RequestMapping("/getVideoRateByClasses")
    public List<VideoVO> getVideoRateByClasses(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId){
        List<VideoVO> list = videoService.getVideoRateByClasses(termId, weekId);
        return list;
    }

    @ResponseBody
    @RequestMapping("/getVideoRateByGrade")
    public List<VideoVO> getVideoRateByGrade(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId){
        List<VideoVO> list = videoService.getVideoRateByGrade(termId, weekId);
        return list;
    }

    @ResponseBody
    @RequestMapping("/getVideoRateByCourse")
    public List<VideoVO> getVideoRateByCourse(@RequestParam(value = "gradeId",required = true) Integer gradeId){
        List<VideoVO> list = videoService.getVideoRateByCourse(gradeId);
        return list;
    }
}
