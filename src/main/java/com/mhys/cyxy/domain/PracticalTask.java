package com.mhys.cyxy.domain;

import lombok.Data;

@Data
public class PracticalTask {
    private int pratical_task_id;
    private int course_id;
    private int chapter_id;
    private int term_id;
    private int week_id;
    private int classes_id;
    private int lecturer_id;
    private int tutor_id;
    private int should_fulfil_num;
    private int real_fulfil_num;
}
