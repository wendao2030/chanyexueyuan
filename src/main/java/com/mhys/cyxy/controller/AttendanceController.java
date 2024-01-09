package com.mhys.cyxy.controller;

import com.mhys.cyxy.domain.vo.AttendanceVO;
import com.mhys.cyxy.service.IAttendanceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
public class AttendanceController {

    @Autowired
    private IAttendanceService attendanceService;

    @RequestMapping("/getAttendanceByTime")
    @ResponseBody
    public AttendanceVO getAttendanceByTime(@RequestParam(value = "time") LocalDate time) throws ParseException {
        if(time == null){
            time = LocalDate.now();
        }
        return attendanceService.getAttendanceByTime(time);
    }

    @RequestMapping("/getAttendanceByGrade")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByGrade(@RequestParam(value = "time") LocalDate time) throws ParseException {
        if(time == null){
            time = LocalDate.now();
        }
        return attendanceService.getAttendanceByGrade(time);
    }

    @RequestMapping("/getAttendanceByTutor")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByTutor(@RequestParam(value = "time") LocalDate time) throws ParseException {
        if(time == null){
            time = LocalDate.now();
        }
        return attendanceService.getAttendanceByTutor(time);
    }

    @RequestMapping("/getAttendanceByLecturer")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByLecturer(@RequestParam(value = "time") LocalDate time) throws ParseException {
        if(time == null){
            time = LocalDate.now();
        }
        return attendanceService.getAttendanceByLecturer(time);
    }

    @RequestMapping("/getAttendanceByClasses")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByClasses(@RequestParam(value = "time") LocalDate time) throws ParseException {
        if(time == null){
            time = LocalDate.now();
        }
        return attendanceService.getAttendanceByClasses(time);
    }

    @RequestMapping("/getAttendanceByWeek")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByWeek(@RequestParam(value = "beginTime") LocalDate beginTime, @RequestParam(value = "endTime") LocalDate endTime) throws ParseException {
        if(beginTime == null){
            beginTime = LocalDate.now();
        }
        if(endTime == null){
            endTime = LocalDate.now();
        }
        return attendanceService.getAttendanceByWeek(beginTime, endTime);
    }
}
