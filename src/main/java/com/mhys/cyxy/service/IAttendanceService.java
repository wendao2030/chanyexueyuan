package com.mhys.cyxy.service;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.Attendance;
import com.mhys.cyxy.domain.dto.AttendanceDTO;
import com.mhys.cyxy.domain.vo.AttendanceVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface IAttendanceService {

    AttendanceVO getAttendanceByTime(LocalDate time);
    List<AttendanceVO> getAttendanceByGrade(LocalDate time);
    List<AttendanceVO> getAttendanceByTutor(LocalDate time);
    List<AttendanceVO> getAttendanceByLecturer(LocalDate time);
    List<AttendanceVO> getAttendanceByClasses(LocalDate time);
    List<AttendanceVO> getAttendanceByWeek(LocalDate beginTime, LocalDate endTime);
    PageInfo<AttendanceVO> selectAllAttendanceByPage(AttendanceDTO attendanceDTO);
    AttendanceVO selectAttendanceById(Integer attendanceId);
    boolean addAttendance(Attendance attendance);
    boolean deleteAttendanceById(Integer attendanceId);
}
