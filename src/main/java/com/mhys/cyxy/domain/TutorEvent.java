package com.mhys.cyxy.domain;

import lombok.Data;

@Data
public class TutorEvent {
    private int tutorEventId;
    private int tutorId;
    private String tutorEventName;
    private String tutorEventContent;
}
