package com.mhys.cyxy.domain.dto;

import lombok.Data;

import java.time.LocalDate;

/*出勤*/
@Data
public class AttendanceDTO extends PageDTO {
    private Integer attendanceId;
    private LocalDate time;
    private Integer classesId;
    private Integer lecturerId;
    private Integer tutorId;
    private Integer isAble;
    private Integer gradeId;

    private String gradeName;
    private String classesName;
    private String lecturerName;
    private String tutorName;
}
