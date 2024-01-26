package com.mhys.cyxy.domain.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentActivityVO {
    private Integer studentActivityId;
    private String activityName;
    private String activityContent;
    private Integer classesId;
    private Integer tutorId;
    private Integer lecturerId;
    private LocalDate time;

    private String tutorName;
    private String lecturerName;
    private String classesName;

    private Integer activityNum;
}
