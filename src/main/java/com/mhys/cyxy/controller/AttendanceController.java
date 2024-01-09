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
    public AttendanceVO getAttendanceByTime(@RequestParam(value = "time") String time) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        return attendanceService.getAttendanceByTime(fmt.parse(time));
    }

    @RequestMapping("/getAttendanceByGrade")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByGrade(@RequestParam(value = "time") String time) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        return attendanceService.getAttendanceByGrade(fmt.parse(time));
    }

    @RequestMapping("/getAttendanceByTutor")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByTutor(@RequestParam(value = "time") String time) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        return attendanceService.getAttendanceByTutor(fmt.parse(time));
    }

    @RequestMapping("/getAttendanceByLecturer")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByLecturer(@RequestParam(value = "time") String time) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        return attendanceService.getAttendanceByLecturer(fmt.parse(time));
    }

    @RequestMapping("/getAttendanceByClasses")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByClasses(@RequestParam(value = "time") String time) throws ParseException {
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        return attendanceService.getAttendanceByClasses(fmt.parse(time));
    }

}
