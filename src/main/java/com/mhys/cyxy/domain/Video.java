package com.mhys.cyxy.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Video {
    private int videoId;
    private int courseId;
    private int chapterId;
    private int classesId;
    private int termId;
    private int weekId;
    private float rate;
    private int shouldWatchNum;
    private int realWatchNum;
}
