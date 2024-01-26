package com.mhys.cyxy.controller;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.Attendance;
import com.mhys.cyxy.domain.ResponseData;
import com.mhys.cyxy.domain.WeeklyExam;
import com.mhys.cyxy.domain.dto.AttendanceDTO;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.vo.AttendanceVO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import com.mhys.cyxy.service.IAttendanceService;
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
public class AttendanceController {

    private final int ATTENDANCE_DAY_RANGE = 7;

    @Autowired
    private IAttendanceService attendanceService;

    @RequestMapping("/getAttendanceByTime")
    @ResponseBody
    public AttendanceVO getAttendanceByTime(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        return attendanceService.getAttendanceByTime(time);
    }

    @RequestMapping("/getAttendanceByGrade")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByGrade(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        return attendanceService.getAttendanceByGrade(time);
    }

    @RequestMapping("/getAttendanceByTutor")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByTutor(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        return attendanceService.getAttendanceByTutor(time);
    }

    @RequestMapping("/getAttendanceByLecturer")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByLecturer(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        return attendanceService.getAttendanceByLecturer(time);
    }

    @RequestMapping("/getAttendanceByClasses")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByClasses(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        return attendanceService.getAttendanceByClasses(time);
    }

    @RequestMapping("/getAttendanceByWeek")
    @ResponseBody
    public List<AttendanceVO> getAttendanceByWeek(@RequestParam(value = "beginTime", required = false) LocalDate beginTime, @RequestParam(value = "endTime", required = false) LocalDate endTime) throws ParseException {
        List<AttendanceVO> list = attendanceService.getAttendanceByWeek(beginTime, endTime);
        list.stream().forEach(item->item.setAttendanceDayRange(ATTENDANCE_DAY_RANGE));
        return list;
    }

    @ResponseBody
    @PostMapping("/selectAllAttendanceByPage")
    public ResponseData<PageInfo<AttendanceVO>> selectAllAttendanceByPage(@RequestBody AttendanceDTO attendanceDTO){
        PageInfo<AttendanceVO> pageInfo = attendanceService.selectAllAttendanceByPage(attendanceDTO);
        return new ResponseData<>(pageInfo);
    }

    /*根据id查询*/
    @ResponseBody
    @RequestMapping("/selectAttendanceById")
    public ResponseData<AttendanceVO> selectAttendanceById(@RequestParam(value = "attendanceId",required = true) Integer attendanceId){
        AttendanceVO attendanceVO = attendanceService.selectAttendanceById(attendanceId);
        log.info("根据id查询出勤情况");
        return new ResponseData<>(attendanceVO);
    }

    /*新增和修改一条记录*/
    @ResponseBody
    @PostMapping("/addAttendance")
    public ResponseData<Object> addAttendance(@RequestBody Attendance attendance){
        boolean result = attendanceService.addAttendance(attendance);
        return new ResponseData<>(result);
    }

    /*根据id删除*/
    @ResponseBody
    @PostMapping("/deleteAttendanceById")
    public ResponseData<Object> deleteAttendanceById(@RequestParam(value = "attendanceId",required = true) Integer attendanceId){
        boolean result = attendanceService.deleteAttendanceById(attendanceId);
        if(result){
            log.warn("删除一条出勤记录");
        }
        return new ResponseData<>(result);
    }
}
