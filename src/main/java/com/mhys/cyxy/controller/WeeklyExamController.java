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
    public ResponseData<List<WeeklyExamVO>> getExamResultByClasses(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId) {
        try {
            List<WeeklyExamVO> list = weeklyExamService.getExamResultByClasses(termId, weekId);
            log.info("根据班级查询周测成绩成功");
            return new ResponseData<>(list);
        }catch (Exception e){
            log.error("根据班级查询周测成绩接口失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }

    }

    @RequestMapping("/getExamResultByWeek")
    @ResponseBody
    public ResponseData<List<WeeklyExamVO>> getExamResultByWeek(@RequestParam(value = "beginWeekId", required = false) Integer beginWeekId, @RequestParam(value = "endWeekId", required = false) Integer endWeekId) {
        try {
            List<WeeklyExamVO> list = weeklyExamService.getExamResultByWeek(beginWeekId, endWeekId);
            list.stream().forEach(item->item.setExamWeekRange(Exam_WEEK_RANGE));
            log.info("按周查询周测成绩成功");
            return new ResponseData<>(list);
        }catch (Exception e){
            log.error("按周查询周测成绩接口失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @ResponseBody
    @PostMapping("/selectAllExamResultByPage")
    public ResponseData<PageInfo<WeeklyExamVO>> selectAllExamResultByPage(@RequestBody WeeklyExamDTO weeklyExamDTO){
        try {
            PageInfo<WeeklyExamVO> pageInfo = weeklyExamService.selectAllExamResultByPage(weeklyExamDTO);
            log.info("条件分页查询周测成绩成功");
            return new ResponseData<>(pageInfo);
        }catch (Exception e){
            log.error("条件分页查询周测成绩接口失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*根据id查询*/
    @ResponseBody
    @RequestMapping("/selectExamResultById")
    public ResponseData<WeeklyExamVO> selectExamResultById(@RequestParam(value = "examId",required = true) Integer examId){
        try {
            WeeklyExamVO weeklyExamVO = weeklyExamService.selectExamResultById(examId);
            log.info("根据id查询周测情况");
            return new ResponseData<>(weeklyExamVO);
        }catch (Exception e){
            log.error("根据id查询周测成绩接口失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*新增或修改一条记录*/
    @ResponseBody
    @PostMapping("/addWeeklyExam")
    public ResponseData<Object> addWeeklyExam(@RequestBody WeeklyExam weeklyExam){
        try {
            if (weeklyExam.getClassesId() == null || weeklyExam.getCourseId() == null||
                weeklyExam.getTermId() == null || weeklyExam.getWeekId() ==null ||
                weeklyExam.getTutorId() ==null || weeklyExam.getLecturerId() ==null){
                return ResponseData.fail("参数传递缺失");
            }
            boolean result = weeklyExamService.addWeeklyExam(weeklyExam);
            if (result){
                log.info("新增或修改周测成绩成功");
                return new ResponseData<>(result);
            }else {
                log.warn("新增或修改周测成绩失败");
                return ResponseData.fail();
            }
        }catch (Exception e){
            log.error("新增或修改一条周测成绩接口失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*根据id删除*/
    @ResponseBody
    @PostMapping("/deleteWeeklyExamById")
    public ResponseData<Object> deleteWeeklyExamById(@RequestParam(value = "examId",required = true) Integer examId){
        try {
            boolean result = weeklyExamService.deleteWeeklyExamById(examId);
            if(result){
                log.info("删除一条周测记录成功");
                return new ResponseData<>(result);
            }else {
                log.warn("删除一条周测记录失败");
                return ResponseData.error();
            }
        }catch (Exception e){
            log.error("新增或修改一条周测成绩接口失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }
}
