package com.mhys.cyxy.service;

import com.mhys.cyxy.domain.vo.AttendanceVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface IAttendanceService {

    AttendanceVO getAttendanceByTime(Date time);
    List<AttendanceVO> getAttendanceByGrade(Date time);
    List<AttendanceVO> getAttendanceByTutor(Date time);
    List<AttendanceVO> getAttendanceByLecturer(Date time);
    List<AttendanceVO> getAttendanceByClasses(Date time);
}
