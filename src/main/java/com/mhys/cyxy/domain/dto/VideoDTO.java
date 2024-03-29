package com.mhys.cyxy.domain.dto;

import lombok.Data;

@Data
public class VideoDTO extends PageDTO{
    private Integer termId;
    private Integer weekId;
    private Integer gradeId;
    private Integer classesId;
    private Integer courseId;
    private Integer chapterId;
    private Integer tutorId;
    private Integer lecturerId;
    private Integer isAble;

    private String termName;
    private String weekName;
    private String gradeName;
    private String classesName;
    private String courseName;
    private String chapterName;
    private String tutorName;
    private String lecturerName;
}
