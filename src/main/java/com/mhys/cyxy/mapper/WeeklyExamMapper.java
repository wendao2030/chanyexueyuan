package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.PracticalTask;
import com.mhys.cyxy.domain.WeeklyExam;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.dto.WeeklyExamDTO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WeeklyExamMapper {
    public List<WeeklyExamVO> getExamResultByClasses(@Param("termId") Integer termId, @Param("weekId") Integer weekId);
    public List<WeeklyExamVO> getExamResultByWeek(@Param("beginWeekId") Integer beginWeekId, @Param("endWeekId") Integer endWeekId);
    public WeeklyExamVO getAllExamResult(@Param("termId") Integer termId, @Param("weekId") Integer weekId);
    public int getMaxTermId();
    public int getMaxWeekId();
    public List<WeeklyExamVO> selectAllExamResultByPage(WeeklyExamDTO weeklyExamDTO);
    WeeklyExamVO selectExamResultById(Integer examId);
    public int updateWeeklyExam(WeeklyExam weeklyExam);
    public int addWeeklyExam(WeeklyExam weeklyExam);
    public int deleteWeeklyExamById(Integer examId);
}
