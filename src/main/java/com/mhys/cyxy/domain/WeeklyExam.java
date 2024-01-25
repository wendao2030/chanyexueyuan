package com.mhys.cyxy.domain;

import lombok.Data;

@Data
public class WeeklyExam {
    private int examId;
    private int courseId;
    private int classesId;
    private int termId;
    private int weekId;
    private int lecturerId;
    private int tutorId;
    private int isAble;

    private Integer lt60;
    private Integer gt60Lt70;
    private Integer gt70Lt80;
    private Integer gt80Lt90;
    private Integer gt90Lt100;

    private Integer studentsNum;
}
