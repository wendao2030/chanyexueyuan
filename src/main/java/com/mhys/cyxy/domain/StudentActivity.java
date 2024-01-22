package com.mhys.cyxy.domain;

import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentActivity {
    private int studentActivityId;
    private String activityName;
    private String activityContent;
    private int classesId;
    private int tutorId;
    private int lecturerId;
    private LocalDate time;
}
