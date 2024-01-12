package com.mhys.cyxy.service;

import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IPracticalTaskService {
    public List<PracticalTaskVO> getTaskResultByClasses(Integer itemId, Integer weekId);
}
