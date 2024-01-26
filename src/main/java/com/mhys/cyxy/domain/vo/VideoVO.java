package com.mhys.cyxy.domain.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VideoVO {

    private Integer videoId;
    private Integer courseId;
    private Integer chapterId;
    private Integer classesId;
    private Integer gradeId;
    private Integer termId;
    private Integer weekId;
    private Integer isAble;
    private Integer tutorId;
    private Integer lecturerId;

    private Float rate;
    private Integer shouldWatchNum;
    private Integer realWatchNum;

    private String termName;
    private String weekName;
    private String courseName;
    private String chapterName;
    private String gradeName;
    private String classesName;
    private String tutorName;
    private String lecturerName;

    private Integer videoDayRange;
}
