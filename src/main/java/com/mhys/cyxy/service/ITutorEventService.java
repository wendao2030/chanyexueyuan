package com.mhys.cyxy.service;

import com.mhys.cyxy.domain.vo.TutorEventVO;

import java.util.List;

public interface ITutorEventService {
    public List<TutorEventVO> getCountByTutor();

    public TutorEventVO getAllCount();
}
