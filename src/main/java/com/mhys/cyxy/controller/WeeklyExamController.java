package com.mhys.cyxy.controller;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.PracticalTask;
import com.mhys.cyxy.domain.ResponseData;
import com.mhys.cyxy.domain.WeeklyExam;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.dto.WeeklyExamDTO;
import com.mhys.cyxy.domain.vo.AttendanceVO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import com.mhys.cyxy.service.IVideoService;
import com.mhys.cyxy.service.IWeeklyExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class WeeklyExamController {

    private final int Exam_WEEK_RANGE = 7;

    @Autowired
    private IWeeklyExamService weeklyExamService;

    @RequestMapping("/getExamResultByClasses")
    @ResponseBody
    public List<WeeklyExamVO> getExamResultByClasses(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId) {
        return weeklyExamService.getExamResultByClasses(termId, weekId);
    }

    @RequestMapping("/getExamResultByWeek")
    @ResponseBody
    public List<WeeklyExamVO> getExamResultByWeek(@RequestParam(value = "beginWeekId", required = false) Integer beginWeekId, @RequestParam(value = "endWeekId", required = false) Integer endWeekId) {
        List<WeeklyExamVO> list = weeklyExamService.getExamResultByWeek(beginWeekId, endWeekId);
        list.stream().forEach(item->item.setExamWeekRange(Exam_WEEK_RANGE));
        return list;
    }

    @ResponseBody
    @PostMapping("/selectAllExamResultByPage")
    public ResponseData<PageInfo<WeeklyExamVO>> selectAllExamResultByPage(@RequestBody WeeklyExamDTO weeklyExamDTO){
        PageInfo<WeeklyExamVO> pageInfo = weeklyExamService.selectAllExamResultByPage(weeklyExamDTO);
        return new ResponseData<>(pageInfo);
    }

    /*根据id查询*/
    @ResponseBody
    @RequestMapping("/selectExamResultById")
    public ResponseData<WeeklyExamVO> selectExamResultById(@RequestParam(value = "examId",required = true) Integer examId){
        WeeklyExamVO weeklyExamVO = weeklyExamService.selectExamResultById(examId);
        log.info("根据id查询周测情况");
        return new ResponseData<>(weeklyExamVO);
    }

    /*新增和修改一条记录*/
    @ResponseBody
    @PostMapping("/addWeeklyExam")
    public ResponseData<Object> addWeeklyExam(@RequestBody WeeklyExam weeklyExam){
        boolean result = weeklyExamService.addWeeklyExam(weeklyExam);
        return new ResponseData<>(result);
    }

    /*根据id删除*/
    @ResponseBody
    @PostMapping("/deleteWeeklyExamById")
    public ResponseData<Object> deleteWeeklyExamById(@RequestParam(value = "examId",required = true) Integer examId){
        boolean result = weeklyExamService.deleteWeeklyExamById(examId);
        if(result){
            log.warn("删除一条周测记录");
        }
        return new ResponseData<>(result);
    }
}
