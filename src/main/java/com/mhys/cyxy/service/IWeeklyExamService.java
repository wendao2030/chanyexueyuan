package com.mhys.cyxy.service;

import com.mhys.cyxy.domain.vo.WeeklyExamVO;

import java.util.List;

public interface IWeeklyExamService {
    public List<WeeklyExamVO> getExamResultByClasses(Integer termId, Integer weekId);
}
