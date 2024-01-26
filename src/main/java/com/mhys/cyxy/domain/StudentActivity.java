package com.mhys.cyxy.domain;

import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentActivity {
    private Integer studentActivityId;
    private String activityName;
    private String activityContent;
    private Integer classesId;
    private Integer tutorId;
    private Integer lecturerId;
    private LocalDate time;
}
