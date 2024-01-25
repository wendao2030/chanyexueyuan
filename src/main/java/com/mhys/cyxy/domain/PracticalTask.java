package com.mhys.cyxy.domain;

import lombok.Data;

@Data
public class PracticalTask {
    private int practicalTaskId;
    private int courseId;
    private int chapterId;
    private int termId;
    private int weekId;
    private int classesId;
    private int lecturerId;
    private int tutorId;
    private int shouldFulfilNum;
    private int realFulfilNum;
    private int isAble;
}
