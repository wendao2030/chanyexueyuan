package com.mhys.cyxy.domain.vo;

import com.mhys.cyxy.domain.Attendance;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class AttendanceVO{
    private Integer gradeId;
    private Integer classesId;
    private Integer lecturerId;
    private Integer tutorId;

    private Date time;

    private String tutorName;
    private String lecturerName;
    private String classesName;
    private String gradeName;

    private Integer shouldAttendNum;
    private Integer realAttendNum;
    private String nonAttendDesc;
    private Integer shouldAttendSum;
    private Integer realAttendSum;
    private Float rate;
    private Integer isAble;

    private Integer attendanceDayRange;
}
