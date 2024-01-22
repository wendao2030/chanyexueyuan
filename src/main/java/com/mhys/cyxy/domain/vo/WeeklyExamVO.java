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

    private float lt60Rate;
    private float gt60Lt70Rate;
    private float gt70Lt80Rate;
    private float gt80Lt90Rate;
    private float gt90Lt100Rate;

    private int ExamWeekRange;
}
