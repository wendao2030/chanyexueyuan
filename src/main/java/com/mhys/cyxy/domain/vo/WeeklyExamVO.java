package com.mhys.cyxy.domain.vo;

import lombok.Data;

@Data
public class WeeklyExamVO {
    private int examId;
    private int courseId;
    private int gradeId;
    private int classesId;
    private int termId;
    private int weekId;
    private int lecturerId;
    private int tutorId;
    private int isAble;

    private String termName;
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
    private float lt60Rate;
    private float gt60Lt70Rate;
    private float gt70Lt80Rate;
    private float gt80Lt90Rate;
    private float gt90Lt100Rate;
    private int studentsNum;

    private int ExamWeekRange;
}
