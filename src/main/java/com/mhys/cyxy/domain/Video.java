package com.mhys.cyxy.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Video {
    private Integer videoId;
    private Integer courseId;
    private Integer chapterId;
    private Integer classesId;
    private Integer tutorId;
    private Integer lecturerId;
    private Integer termId;
    private Integer weekId;
    private Float rate;
    private Integer shouldWatchNum;
    private Integer realWatchNum;
    private Integer isAble;
}
