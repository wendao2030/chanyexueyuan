package com.mhys.cyxy.domain;

import lombok.Data;

@Data
public class WeeklyExam {
    private Integer examId;
    private Integer courseId;
    private Integer classesId;
    private Integer termId;
    private Integer weekId;
    private Integer lecturerId;
    private Integer tutorId;
    private Integer isAble;

    private Integer lt60;
    private Integer gt60Lt70;
    private Integer gt70Lt80;
    private Integer gt80Lt90;
    private Integer gt90Lt100;

    private Integer studentsNum;
}
