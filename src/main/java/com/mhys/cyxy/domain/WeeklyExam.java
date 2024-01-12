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

    private int lt60;
    private int gt60Lt70;
    private int gt70Lt80;
    private int gt80Lt90;
    private int gt90Lt100;

    private int studentsNum;
}
