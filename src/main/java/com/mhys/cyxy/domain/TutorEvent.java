package com.mhys.cyxy.domain;

import lombok.Data;

@Data
public class TutorEvent {
    private Integer tutorEventId;
    private Integer tutorId;
    private String tutorEventName;
    private String tutorEventContent;
}
