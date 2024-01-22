package com.mhys.cyxy.domain.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentActivityVO {
    private int studentActivityId;
    private String activityName;
    private String activityContent;
    private int classesId;
    private int tutorId;
    private int lecturerId;
    private LocalDate time;

    private String tutorName;
    private String lecturerName;
    private String classesName;

    private int activityNum;
}
