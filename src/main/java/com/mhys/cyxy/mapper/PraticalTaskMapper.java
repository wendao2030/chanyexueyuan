package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface PraticalTaskMapper {
    public List<PracticalTaskVO> getTaskResultByClasses(@Param("termId") Integer termId,@RequestParam("weekId") Integer weekId);

    public int getMaxTermId();
    public Integer getMaxWeekId();
}
