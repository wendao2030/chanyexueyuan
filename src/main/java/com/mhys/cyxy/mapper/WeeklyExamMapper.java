package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.WeeklyExam;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WeeklyExamMapper {
    public List<WeeklyExamVO> getExamResultByClasses(@Param("termId") Integer termId, @Param("weekId") Integer weekId);
    public List<WeeklyExamVO> getExamResultByWeek(@Param("beginWeekId") Integer beginWeekId, @Param("endWeekId") Integer endWeekId);

    public int getMaxTerm();
    public int getMaxWeek();

}
