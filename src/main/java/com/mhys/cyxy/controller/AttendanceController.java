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
    public ResponseData<AttendanceVO> getAttendanceByTime(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        try {
            AttendanceVO result = attendanceService.getAttendanceByTime(time);
            log.info("按时间查询出勤记录成功");
            return new ResponseData<>(result);
        } catch (Exception e) {
            log.error("根据时间查询出勤接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }

    }

    @RequestMapping("/getAttendanceByGrade")
    @ResponseBody
    public ResponseData<List<AttendanceVO>> getAttendanceByGrade(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        try {
            List<AttendanceVO> list = attendanceService.getAttendanceByGrade(time);
            log.info("按年级查询出勤记录成功");
            return new ResponseData<>(list);
        } catch (Exception e) {
            log.error("根据年级查询出勤接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @RequestMapping("/getAttendanceByTutor")
    @ResponseBody
    public ResponseData<List<AttendanceVO>> getAttendanceByTutor(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        try {
            List<AttendanceVO> list = attendanceService.getAttendanceByTutor(time);
            log.info("按班主任查询出勤记录成功");
            return new ResponseData<>(list);
        } catch (Exception e) {
            log.error("根据班主任查询出勤接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @RequestMapping("/getAttendanceByLecturer")
    @ResponseBody
    public ResponseData<List<AttendanceVO>> getAttendanceByLecturer(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        try {
            List<AttendanceVO> list = attendanceService.getAttendanceByLecturer(time);
            log.info("按讲师查询出勤记录成功");
            return new ResponseData<>(list);
        } catch (Exception e) {
            log.error("根据讲师查询出勤接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @RequestMapping("/getAttendanceByClasses")
    @ResponseBody
    public ResponseData<List<AttendanceVO>> getAttendanceByClasses(@RequestParam(value = "time", required = false) LocalDate time) throws ParseException {
        try {
            List<AttendanceVO> list = attendanceService.getAttendanceByClasses(time);
            log.info("按班级查询出勤记录成功");
            return new ResponseData<>(list);
        } catch (Exception e) {
            log.error("根据班级查询出勤接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @RequestMapping("/getAttendanceByWeek")
    @ResponseBody
    public ResponseData<List<AttendanceVO>> getAttendanceByWeek(@RequestParam(value = "beginTime", required = false) LocalDate beginTime, @RequestParam(value = "endTime", required = false) LocalDate endTime) throws ParseException {
        try {
            List<AttendanceVO> list = attendanceService.getAttendanceByWeek(beginTime, endTime);
            list.stream().forEach(item -> item.setAttendanceDayRange(ATTENDANCE_DAY_RANGE));
            log.info("查询一周内出勤记录成功");
            return new ResponseData<>(list);
        } catch (Exception e) {
            log.error("查询一周内出勤接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @ResponseBody
    @PostMapping("/selectAllAttendanceByPage")
    public ResponseData<PageInfo<AttendanceVO>> selectAllAttendanceByPage(@RequestBody AttendanceDTO attendanceDTO) {
        try {
            PageInfo<AttendanceVO> pageInfo = attendanceService.selectAllAttendanceByPage(attendanceDTO);
            log.info("条件分页查询出勤记录成功");
            return new ResponseData<>(pageInfo);
        } catch (Exception e) {
            log.error("条件分页查询出勤接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*根据id查询*/
    @ResponseBody
    @RequestMapping("/selectAttendanceById")
    public ResponseData<AttendanceVO> selectAttendanceById(@RequestParam(value = "attendanceId", required = true) Integer attendanceId) {
        try {
            AttendanceVO attendanceVO = attendanceService.selectAttendanceById(attendanceId);
            log.info("根据id查询出勤记录");
            return new ResponseData<>(attendanceVO);
        } catch (Exception e) {
            log.error("根据id查询出勤接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*新增和修改一条记录*/
    @ResponseBody
    @PostMapping("/addAttendance")
    public ResponseData<Object> addAttendance(@RequestBody Attendance attendance) {
        try {
            boolean result = attendanceService.addAttendance(attendance);
            log.info("新增或修改一条出勤记录");
            return new ResponseData<>(result);
        } catch (Exception e) {
            log.error("新增和修改一条出勤记录接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*根据id删除*/
    @ResponseBody
    @PostMapping("/deleteAttendanceById")
    public ResponseData<Object> deleteAttendanceById(@RequestParam(value = "attendanceId", required = true) Integer attendanceId) {
        try {
            boolean result = attendanceService.deleteAttendanceById(attendanceId);
            log.info("删除一条出勤记录");
            return new ResponseData<>(result);
        } catch (Exception e) {
            log.error("根据id删除接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }
}
