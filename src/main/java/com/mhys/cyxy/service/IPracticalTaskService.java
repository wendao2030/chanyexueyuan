package com.mhys.cyxy.service;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.PracticalTask;
import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.dto.VideoDTO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.VideoVO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IPracticalTaskService {
    public List<PracticalTaskVO> getTaskResultByClasses(Integer itemId, Integer weekId);
    PageInfo<PracticalTaskVO> selectAllTaskResultByPage(PracticalTaskDTO practicalTaskDTO);
    boolean addPracticalTask(PracticalTask practicalTask);
    PracticalTaskVO selectTaskResultById(Integer practicalTaskId);
    boolean deletePracticalTaskById(Integer practicalTaskId);
}
