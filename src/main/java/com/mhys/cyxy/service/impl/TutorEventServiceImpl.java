package com.mhys.cyxy.service.impl;

import com.mhys.cyxy.domain.vo.TutorEventVO;
import com.mhys.cyxy.mapper.TutorEventMapper;
import com.mhys.cyxy.service.ITutorEventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TutorEventServiceImpl implements ITutorEventService {

    @Resource
    private TutorEventMapper tutorEventMapper;

    @Override
    public List<TutorEventVO> getCountByTutor() {
        return tutorEventMapper.getCountByTutor();
    }

    @Override
    public TutorEventVO getAllCount() {
        return tutorEventMapper.getAllCount();
    }
}
