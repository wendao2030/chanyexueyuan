package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.Attendance;
import com.mhys.cyxy.domain.PracticalTask;
import com.mhys.cyxy.domain.dto.AttendanceDTO;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.vo.AttendanceVO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
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
    /*统计最近一周每日总出勤*/
    public List<AttendanceVO> getAttendanceByWeek(@Param("beginTime") LocalDate beginTime, @Param("endTime") LocalDate endTime);
    /*统计最近一周总出勤率*/
    public AttendanceVO getAllAttendance(@Param("beginTime") LocalDate beginTime, @Param("endTime") LocalDate endTime);
    /*查询最近的日期*/
    public Date getLastDay();

    public List<AttendanceVO> selectAllAttendanceByPage(AttendanceDTO attendanceDTO);

    public AttendanceVO selectAttendanceById(int attendanceId);

    public int updateAttendance(Attendance attendance);

    public int addAttendance(Attendance attendance);

    public int deleteAttendanceById(Integer attendanceId);
}
