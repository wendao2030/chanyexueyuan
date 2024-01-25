package com.mhys.cyxy.domain.dto;

import lombok.Data;

@Data
public class PracticalTaskDTO extends PageDTO {
    private Integer courseId;
    private Integer chapterId;
    private Integer termId;
    private Integer weekId;
    private Integer gradeId;
    private Integer classesId;
    private Integer tutorId;
    private Integer lecturerId;
    private Integer isAble;

    private String gradeName;
    private String classesName;
    private String termName;
    private String weekName;
    private String courseName;
    private String chapterName;
    private String tutorName;
    private String lecturerName;
}
