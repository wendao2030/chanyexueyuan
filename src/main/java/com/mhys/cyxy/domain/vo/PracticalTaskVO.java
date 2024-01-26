package com.mhys.cyxy.domain.vo;

import lombok.Data;

@Data
public class PracticalTaskVO {
    private Integer practicalTaskId;
    private Integer courseId;
    private Integer chapterId;
    private Integer termId;
    private Integer weekId;
    private Integer gradeId;
    private Integer classesId;
    private Integer lecturerId;
    private Integer tutorId;
    private Integer shouldFulfilNum;
    private Integer realFulfilNum;
    private Integer isAble;
    private Float rate;
    private String gradeName;
    private String classesName;
    private String termName;
    private String weekName;
    private String courseName;
    private String chapterName;
    private String tutorName;
    private String lecturerName;
}
