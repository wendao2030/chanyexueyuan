package com.mhys.cyxy.service.impl;

import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import com.mhys.cyxy.mapper.WeeklyExamMapper;
import com.mhys.cyxy.service.IWeeklyExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WeeklyExamServiceImpl implements IWeeklyExamService {

    @Resource
    private WeeklyExamMapper weeklyExamMapper;

    @Override
    public List<WeeklyExamVO> getExamResultByClasses(Integer termId, Integer weekId) {
        if (termId == null){
            termId = weeklyExamMapper.getMaxTerm();
        }
        if(weekId == null){
            weekId = weeklyExamMapper.getMaxWeek();
        }
        return weeklyExamMapper.getExamResultByClasses(termId, weekId);
    }

    @Override
    public List<WeeklyExamVO> getExamResultByWeek(Integer beginWeekId, Integer endWeekId) {
        if (endWeekId == null){
            endWeekId = weeklyExamMapper.getMaxWeek();
        }
        if(beginWeekId == null){
            beginWeekId = endWeekId - 7;
        }

        return weeklyExamMapper.getExamResultByWeek(beginWeekId,endWeekId);
    }
}
