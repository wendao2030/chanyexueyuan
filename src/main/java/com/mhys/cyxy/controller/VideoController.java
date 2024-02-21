package com.mhys.cyxy.controller;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.ResponseData;
import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.dto.VideoDTO;
import com.mhys.cyxy.domain.vo.VideoVO;
import com.mhys.cyxy.service.IVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class VideoController {

    @Autowired
    private IVideoService videoService;

    @ResponseBody
    @RequestMapping("/getAllVideoRate")
    public ResponseData<VideoVO> getAllVideoRate(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId){
        try {
            VideoVO vo = videoService.getAllVideoRate(termId, weekId);
            log.info("查询整体moot观看比率成功");
            return new ResponseData<>(vo);
        }catch (Exception e){
            log.error("查询整体moot观看比率接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @ResponseBody
    @RequestMapping("/getVideoRateByClasses")
    public ResponseData<List<VideoVO>> getVideoRateByClasses(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId){
        try {
            List<VideoVO> list = videoService.getVideoRateByClasses(termId, weekId);
            log.info("按班级查询moot观看比率成功");
            return new ResponseData<>(list);
        }catch (Exception e){
            log.error("按班级查询moot观看比率接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @ResponseBody
    @RequestMapping("/getVideoRateByGrade")
    public ResponseData<List<VideoVO>> getVideoRateByGrade(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId){
        try {
            List<VideoVO> list = videoService.getVideoRateByGrade(termId, weekId);
            log.info("按年级查询moot观看比率成功");
            return new ResponseData<>(list);
        }catch (Exception e){
            log.error("按年级查询moot观看比率接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @ResponseBody
    @RequestMapping("/getVideoRateByCourse")
    public ResponseData<List<VideoVO>> getVideoRateByCourse(@RequestParam(value = "gradeId",required = true) Integer gradeId){
        try {
            List<VideoVO> list = videoService.getVideoRateByCourse(gradeId);
            log.info("按课程查询moot观看比率成功");
            return new ResponseData<>(list);
        }catch (Exception e){
            log.error("按课程查询moot观看比率接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*条件分页查询所有moot观看情况，按照时间降序*/
    @ResponseBody
    @PostMapping("/selectAllVideoByPage")
    public ResponseData<PageInfo<VideoVO>> selectAllVideoByPage(@RequestBody VideoDTO videoDTO){
        try {
            PageInfo<VideoVO> pageInfo = videoService.selectAllVideoByPage(videoDTO);
            log.info("条件分页查询所有moot观看情况成功");
            return new ResponseData<>(pageInfo);
        }catch (Exception e){
            log.error("条件分页查询所有moot观看情况接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*新增和修改一条记录*/
    @ResponseBody
    @PostMapping("/addVideo")
    public ResponseData<Object> addVideo(@RequestBody Video video){
        try {
            if(video.getCourseId() == null || video.getChapterId() == null ||
                video.getClassesId() == null || video.getLecturerId() == null || video.getTutorId() ==null||
                    video.getTermId() == null || video.getWeekId() == null){
                return  ResponseData.fail("参数传递缺失");
            }
            boolean result = videoService.addVideo(video);
            if (result){
                log.info("新增或修改一条记录成功");
                return new ResponseData<>(result);
            }else {
                log.warn("新增或修改一条记录失败");
                return ResponseData.fail();
            }
        }catch (Exception e){
            log.error("新增或修改一条记录接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*根据id删除*/
    @ResponseBody
    @PostMapping("/deleteVideoById")
    public ResponseData<Object> deleteVideoById(@RequestParam(value = "videoId",required = true) Integer videoId){
        try {
            boolean result = videoService.deleteVideoById(videoId);
            if (result){
                log.info("根据id删除一条记录成功");
                return new ResponseData<>(result);
            }else {
                log.info("根据id删除一条记录失败");
                return ResponseData.fail();
            }
        }catch (Exception e){
            log.error("根据id删除一条记录接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*根据id查询*/
    @ResponseBody
    @RequestMapping("/selectVideoById")
    public ResponseData<VideoVO> selectVideoById(@RequestParam(value = "videoId",required = true) Integer videoId){
        try {
            VideoVO videoVO = videoService.selectVideoById(videoId);
            log.info("根据id查询moot观看记录成功");
            return new ResponseData<>(videoVO);
        }catch (Exception e){
            log.error("根据id查询moot观看记录接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

}
