package com.mhys.cyxy.domain.dto;

import lombok.Data;

@Data
public class VideoDTO extends PageDTO{
    private Integer termId;
    private Integer weekId;
    private Integer classesId;
    private Integer courseId;
    private Integer gradeId;

    private String termName;
    private String weekName;
    private String classesName;
    private String courseName;
    private String gradeName;
}
