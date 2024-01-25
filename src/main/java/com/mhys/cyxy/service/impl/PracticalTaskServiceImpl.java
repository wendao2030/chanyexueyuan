package com.mhys.cyxy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.PracticalTask;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.VideoVO;
import com.mhys.cyxy.mapper.PracticalTaskMapper;
import com.mhys.cyxy.service.IPracticalTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PracticalTaskServiceImpl implements IPracticalTaskService {

    @Resource
    private PracticalTaskMapper practicalTaskMapper;

    @Override
    public List<PracticalTaskVO> getTaskResultByClasses(Integer termId, Integer weekId) {
        if(termId == null){
            termId = practicalTaskMapper.getMaxTermId();
        }
        if (weekId == null){
            weekId = practicalTaskMapper.getMaxWeekId();
        }
        return practicalTaskMapper.getTaskResultByClasses(termId, weekId);
    }

    @Override
    public PageInfo<PracticalTaskVO> selectAllTaskResultByPage(PracticalTaskDTO practicalTaskDTO) {
        PageHelper.startPage(practicalTaskDTO.getPageNum(), practicalTaskDTO.getPageSize());
        List<PracticalTaskVO> list = practicalTaskMapper.selectAllTaskResultByPage(practicalTaskDTO);
        return new PageInfo<>(list);
    }

    @Override
    public boolean addPracticalTask(PracticalTask practicalTask) {
        if(practicalTask.getPracticalTaskId() != 0) {
            PracticalTaskVO vo = practicalTaskMapper.selectTaskResultById(practicalTask.getPracticalTaskId());
            if(vo != null){
                //修改
                return practicalTaskMapper.updatePracticalTask(practicalTask) > 0;
            }
        }
        //新增
        return practicalTaskMapper.addPracticalTask(practicalTask) >0;
    }

    @Override
    public PracticalTaskVO selectTaskResultById(Integer practicalTaskId) {
        return practicalTaskMapper.selectTaskResultById(practicalTaskId);
    }

    @Override
    public boolean deletePracticalTaskById(Integer practicalTaskId) {
        return practicalTaskMapper.deletePracticalTaskById(practicalTaskId) > 0;
    }
}
