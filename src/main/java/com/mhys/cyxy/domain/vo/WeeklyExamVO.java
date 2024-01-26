package com.mhys.cyxy.domain.vo;

import lombok.Data;

@Data
public class WeeklyExamVO {
    private Integer examId;
    private Integer courseId;
    private Integer gradeId;
    private Integer classesId;
    private Integer termId;
    private Integer weekId;
    private Integer lecturerId;
    private Integer tutorId;
    private Integer isAble;

    private String termName;
    private String weekName;
    private String courseName;
    private String gradeName;
    private String classesName;
    private String lecturerName;
    private String tutorName;
    private Float rate;

    private Integer lt60;
    private Integer gt60Lt70;
    private Integer gt70Lt80;
    private Integer gt80Lt90;
    private Integer gt90Lt100;
    private Float lt60Rate;
    private Float gt60Lt70Rate;
    private Float gt70Lt80Rate;
    private Float gt80Lt90Rate;
    private Float gt90Lt100Rate;
    private Integer studentsNum;

    private Integer ExamWeekRange;
}
