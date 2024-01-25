package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.PracticalTask;
import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.dto.VideoDTO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.VideoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface PracticalTaskMapper {
    public List<PracticalTaskVO> getTaskResultByClasses(@Param("termId") Integer termId,@RequestParam("weekId") Integer weekId);

    public PracticalTaskVO getAllTaskResult(@Param("termId") Integer termId,@RequestParam("weekId") Integer weekId);

    public int getMaxTermId();
    public Integer getMaxWeekId();

    public List<PracticalTaskVO> selectAllTaskResultByPage(PracticalTaskDTO practicalTaskDTO);

    public PracticalTaskVO selectTaskResultById(int praticalTaskId);

    public int updatePracticalTask(PracticalTask practicalTask);

    public int addPracticalTask(PracticalTask practicalTask);

    public int deletePracticalTaskById(Integer practicalTaskId);
}
