package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.WeeklyExam;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WeeklyExamMapper {
    public List<WeeklyExamVO> getExamResultByClasses(@Param("termId") int termId, @Param("weekId") int weekId);
    public int getMaxTerm();
    public int getMaxWeek();
}
