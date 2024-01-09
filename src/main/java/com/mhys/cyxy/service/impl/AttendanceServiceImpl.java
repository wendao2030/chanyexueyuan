package com.mhys.cyxy.service.impl;

import com.mhys.cyxy.domain.vo.AttendanceVO;
import com.mhys.cyxy.mapper.AttendanceMapper;
import com.mhys.cyxy.service.IAttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    @Resource
    private AttendanceMapper attendanceMapper;

    @Override
    public AttendanceVO getAttendanceByTime(LocalDate time) {
        return attendanceMapper.getAttendanceByTime(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByGrade(LocalDate time) {
        return attendanceMapper.getAttendanceByGrade(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByTutor(LocalDate time) {
        return attendanceMapper.getAttendanceByTutor(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByLecturer(LocalDate time) {
        return attendanceMapper.getAttendanceByLecturer(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByClasses(LocalDate time) {
        return attendanceMapper.getAttendanceByClasses(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByWeek(LocalDate beginTime, LocalDate endTime) {
        return attendanceMapper.getAttendanceByWeek(beginTime, endTime);
    }


}
