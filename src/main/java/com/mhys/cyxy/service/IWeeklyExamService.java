package com.mhys.cyxy.service;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.WeeklyExam;
import com.mhys.cyxy.domain.dto.WeeklyExamDTO;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;

import java.util.List;

public interface IWeeklyExamService {
    public List<WeeklyExamVO> getExamResultByClasses(Integer termId, Integer weekId);

    public List<WeeklyExamVO> getExamResultByWeek(Integer beginWeekId, Integer endWeekId);

    PageInfo<WeeklyExamVO> selectAllExamResultByPage(WeeklyExamDTO weeklyExamDTO);

    WeeklyExamVO selectExamResultById(Integer examId);

    boolean addWeeklyExam(WeeklyExam weeklyExam);

    boolean deleteWeeklyExamById(Integer examId);
}
