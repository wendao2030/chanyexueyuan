package com.mhys.cyxy.domain.vo;

import lombok.Data;

@Data
public class TutorEventVO {
    private Integer tutorEventId;
    private Integer tutorId;
    private String tutorEventName;
    private String tutorEventContent;

    private String tutorName;
    private Integer eventNum;
}
