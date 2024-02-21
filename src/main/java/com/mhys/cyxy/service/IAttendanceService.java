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

    AttendanceVO getAttendanceByTime(LocalDate time) throws Exception;
    List<AttendanceVO> getAttendanceByGrade(LocalDate time) throws Exception;
    List<AttendanceVO> getAttendanceByTutor(LocalDate time) throws Exception;
    List<AttendanceVO> getAttendanceByLecturer(LocalDate time) throws Exception;
    List<AttendanceVO> getAttendanceByClasses(LocalDate time) throws Exception;
    List<AttendanceVO> getAttendanceByWeek(LocalDate beginTime, LocalDate endTime) throws Exception;
    PageInfo<AttendanceVO> selectAllAttendanceByPage(AttendanceDTO attendanceDTO) throws Exception;
    AttendanceVO selectAttendanceById(Integer attendanceId) throws Exception;
    boolean addAttendance(Attendance attendance) throws Exception;
    boolean deleteAttendanceById(Integer attendanceId) throws Exception;
}
