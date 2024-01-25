package com.mhys.cyxy.domain.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VideoVO {

    private int videoId;
    private int courseId;
    private int chapterId;
    private int classesId;
    private int gradeId;
    private int termId;
    private int weekId;
    private int isAble;
    private int tutorId;
    private int lecturerId;

    private float rate;
    private int shouldWatchNum;
    private int realWatchNum;

    private String termName;
    private String weekName;
    private String courseName;
    private String chapterName;
    private String gradeName;
    private String classesName;
    private String tutorName;
    private String lecturerName;

    private int videoDayRange;
}
