package com.mhys.cyxy.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/*出勤*/
@Data
public class Attendance {
    private Integer attendanceId;
    private LocalDate time;
    private Integer classesId;
    private Integer lecturerId;
    private Integer tutorId;
    private Integer shouldAttendNum;
    private Integer realAttendNum;
    private String nonAttendDesc;
    private Integer isAble;
}
