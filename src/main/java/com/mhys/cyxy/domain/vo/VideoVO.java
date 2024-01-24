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

    private float rate;
    private int shouldWatchNum;
    private int realWatchNum;

    private String termName;
    private String weekName;
    private String courseName;
    private String chapterName;
    private String classesName;
    private String gradeName;

    private int videoDayRange;
}
