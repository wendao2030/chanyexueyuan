package com.mhys.cyxy.service.impl;

import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.mapper.PraticalTaskMapper;
import com.mhys.cyxy.service.IPracticalTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PracticalTaskServiceImpl implements IPracticalTaskService {

    @Resource
    private PraticalTaskMapper praticalTaskMapper;

    @Override
    public List<PracticalTaskVO> getTaskResultByClasses(Integer termId, Integer weekId) {
        if(termId == null){
            termId = praticalTaskMapper.getMaxTermId();
        }
        if (weekId == null){
            weekId = praticalTaskMapper.getMaxWeekId();
        }
        return praticalTaskMapper.getTaskResultByClasses(termId, weekId);
    }
}
