package com.mhys.cyxy.domain.vo;

import com.mhys.cyxy.domain.Attendance;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class AttendanceVO{
    private int gradeId;
    private int classesId;
    private int lecturerId;
    private int tutorId;

    private Date time;

    private String tutorName;
    private String lecturerName;
    private String classesName;
    private String gradeName;

    private int shouldAttendSum;
    private int realAttendSum;
    private float rate;

    private int attendanceDayRange;
}
