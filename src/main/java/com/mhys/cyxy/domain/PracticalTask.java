package com.mhys.cyxy.domain;

import lombok.Data;

@Data
public class PracticalTask {
    private Integer practicalTaskId;
    private Integer courseId;
    private Integer chapterId;
    private Integer termId;
    private Integer weekId;
    private Integer classesId;
    private Integer lecturerId;
    private Integer tutorId;
    private Integer shouldFulfilNum;
    private Integer realFulfilNum;
    private Integer isAble;
}
