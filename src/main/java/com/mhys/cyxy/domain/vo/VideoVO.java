package com.mhys.cyxy.domain.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VideoVO {

    private int videoId;
    private int courseId;
    private int chapterId;
    private int classesId;
    private float rate;
    private LocalDate time;
    private int shouldWatchNum;
    private int realWatchNum;

    private float avg;
    private String courseName;
    private String classesName;
    private String gradeName;

    private int videoDayRange;
}
