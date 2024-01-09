package com.mhys.cyxy.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*出勤*/
@Data
public class Attendance {
    private int attendanceId;
    private Date time;
    private int classesId;
    private int lecturerId;
    private int tutorId;
    private int shouldAttendSum;
    private int realAttendNum;
    private String nonAttendDesc;
}
