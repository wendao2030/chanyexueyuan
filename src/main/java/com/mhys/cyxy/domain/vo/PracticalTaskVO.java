package com.mhys.cyxy.domain.vo;

import lombok.Data;

@Data
public class PracticalTaskVO {
    private int practicalTaskId;
    private int courseId;
    private int chapterId;
    private int termId;
    private int weekId;
    private int gradeId;
    private int classesId;
    private int lecturerId;
    private int tutorId;
    private int shouldFulfilNum;
    private int realFulfilNum;
    private int isAble;
    private float rate;
    private String gradeName;
    private String classesName;
    private String termName;
    private String weekName;
    private String courseName;
    private String chapterName;
    private String tutorName;
    private String lecturerName;
}
