package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.vo.AttendanceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface AttendanceMapper {
    /*统计当日总出勤*/
    public AttendanceVO getAttendanceByTime(@Param("time") LocalDate time);
    /*按年级统计当日出勤*/
    public List<AttendanceVO> getAttendanceByGrade(@Param("time") LocalDate time);
    /*按班主任统计当日总出勤*/
    public List<AttendanceVO> getAttendanceByTutor(@Param("time") LocalDate time);
    /*按讲师统计当日总出勤*/
    public List<AttendanceVO> getAttendanceByLecturer(@Param("time") LocalDate time);
    /*按班级显示当日出勤*/
    public List<AttendanceVO> getAttendanceByClasses(@Param("time") LocalDate time);
    /*统计过去一周每日总出勤*/
    public List<AttendanceVO> getAttendanceByWeek(@Param("beginTime") LocalDate beginTime, @Param("endTime") LocalDate endTime);
}
