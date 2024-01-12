package com.mhys.cyxy.domain.vo;

import lombok.Data;

@Data
public class WeeklyExamVO {
    private String weekName;
    private String courseName;
    private String gradeName;
    private String classesName;
    private String lecturerName;
    private String tutorName;
    private float rate;

    private int lt60;
    private int gt60Lt70;
    private int gt70Lt80;
    private int gt80Lt90;
    private int gt90Lt100;

    private int ExamWeekRange;
}
