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
    public AttendanceVO getAttendanceByTime(Date time) {
        return attendanceMapper.getAttendanceByTime(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByGrade(Date time) {
        return attendanceMapper.getAttendanceByGrade(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByTutor(Date time) {
        return attendanceMapper.getAttendanceByTutor(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByLecturer(Date time) {
        return attendanceMapper.getAttendanceByLecturer(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByClasses(Date time) {
        return attendanceMapper.getAttendanceByClasses(time);
    }


}
