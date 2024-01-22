package com.mhys.cyxy.service.impl;

import com.mhys.cyxy.domain.vo.AttendanceVO;
import com.mhys.cyxy.mapper.AttendanceMapper;
import com.mhys.cyxy.service.IAttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    @Resource
    private AttendanceMapper attendanceMapper;

    @Override
    public AttendanceVO getAttendanceByTime(LocalDate time) {
        if(time == null){
            Date lastDay = attendanceMapper.getLastDay();
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime1 = lastDay.toInstant().atZone(zoneId);
            time = zonedDateTime1.toLocalDate();
        }
        return attendanceMapper.getAttendanceByTime(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByGrade(LocalDate time) {
        if(time == null){
            Date lastDay = attendanceMapper.getLastDay();
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime1 = lastDay.toInstant().atZone(zoneId);
            time = zonedDateTime1.toLocalDate();
        }
        return attendanceMapper.getAttendanceByGrade(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByTutor(LocalDate time) {
        if(time == null){
            Date lastDay = attendanceMapper.getLastDay();
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime1 = lastDay.toInstant().atZone(zoneId);
            time = zonedDateTime1.toLocalDate();
        }
        return attendanceMapper.getAttendanceByTutor(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByLecturer(LocalDate time) {
        if(time == null){
            Date lastDay = attendanceMapper.getLastDay();
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime1 = lastDay.toInstant().atZone(zoneId);
            time = zonedDateTime1.toLocalDate();
        }
        return attendanceMapper.getAttendanceByLecturer(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByClasses(LocalDate time) {
        if(time == null){
            Date lastDay = attendanceMapper.getLastDay();
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime1 = lastDay.toInstant().atZone(zoneId);
            time = zonedDateTime1.toLocalDate();
        }
        return attendanceMapper.getAttendanceByClasses(time);
    }

    @Override
    public List<AttendanceVO> getAttendanceByWeek(LocalDate beginTime, LocalDate endTime) {
        if(endTime == null || endTime == null){
            Date lastDay = attendanceMapper.getLastDay();
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime1 = lastDay.toInstant().atZone(zoneId);
            ZonedDateTime zonedDateTime2 = zonedDateTime1.minusDays(7);
            beginTime = zonedDateTime2.toLocalDate();
            endTime = zonedDateTime1.toLocalDate();
        }

        return attendanceMapper.getAttendanceByWeek(beginTime, endTime);
    }


}
