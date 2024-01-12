package com.mhys.cyxy.controller;

import com.mhys.cyxy.domain.vo.AttendanceVO;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import com.mhys.cyxy.service.IVideoService;
import com.mhys.cyxy.service.IWeeklyExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

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
}
