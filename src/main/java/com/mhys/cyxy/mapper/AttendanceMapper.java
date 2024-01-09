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
    public AttendanceVO getAttendanceByTime(@Param("time") Date time);
    /*按年级统计当日出勤*/
    public List<AttendanceVO> getAttendanceByGrade(@Param("time") Date time);
    /*按班主任统计当日总出勤*/
    public List<AttendanceVO> getAttendanceByTutor(@Param("time") Date time);
    /*按讲师统计当日总出勤*/
    public List<AttendanceVO> getAttendanceByLecturer(@Param("time") Date time);
    /*按班级显示当日出勤*/
    public List<AttendanceVO> getAttendanceByClasses(@Param("time") Date time);
}
