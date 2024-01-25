package com.mhys.cyxy.domain.dto;

import lombok.Data;

@Data
public class WeeklyExamDTO extends PageDTO{
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
}
