package com.mhys.cyxy.domain.vo;

import lombok.Data;

@Data
public class TutorEventVO {
    private int tutorEventId;
    private int tutorId;
    private String tutorEventName;
    private String tutorEventContent;

    private String tutorName;
    private int eventNum;
}
