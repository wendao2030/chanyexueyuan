package com.mhys.cyxy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.WeeklyExam;
import com.mhys.cyxy.domain.dto.WeeklyExamDTO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import com.mhys.cyxy.mapper.WeeklyExamMapper;
import com.mhys.cyxy.service.IWeeklyExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WeeklyExamServiceImpl implements IWeeklyExamService {

    @Resource
    private WeeklyExamMapper weeklyExamMapper;

    @Override
    public List<WeeklyExamVO> getExamResultByClasses(Integer termId, Integer weekId) {
        if (termId == null){
            termId = weeklyExamMapper.getMaxTerm();
        }
        if(weekId == null){
            weekId = weeklyExamMapper.getMaxWeek();
        }
        return weeklyExamMapper.getExamResultByClasses(termId, weekId);
    }

    @Override
    public List<WeeklyExamVO> getExamResultByWeek(Integer beginWeekId, Integer endWeekId) {
        if (endWeekId == null){
            endWeekId = weeklyExamMapper.getMaxWeek();
        }
        if(beginWeekId == null){
            beginWeekId = endWeekId - 7;
        }

        return weeklyExamMapper.getExamResultByWeek(beginWeekId,endWeekId);
    }

    @Override
    public PageInfo<WeeklyExamVO> selectAllExamResultByPage(WeeklyExamDTO weeklyExamDTO) {
        PageHelper.startPage(weeklyExamDTO.getPageNum(), weeklyExamDTO.getPageSize());
        List<WeeklyExamVO> list = weeklyExamMapper.selectAllExamResultByPage(weeklyExamDTO);
        return new PageInfo<>(list);
    }

    @Override
    public WeeklyExamVO selectExamResultById(Integer examId) {
        return weeklyExamMapper.selectExamResultById(examId);
    }

    @Override
    public boolean addWeeklyExam(WeeklyExam weeklyExam) {
        if(weeklyExam.getExamId() != 0) {
            WeeklyExamVO vo = weeklyExamMapper.selectExamResultById(weeklyExam.getExamId());
            if(vo != null){
                //修改
                return weeklyExamMapper.updateWeeklyExam(weeklyExam) > 0;
            }
        }
        //新增
        return weeklyExamMapper.addWeeklyExam(weeklyExam) >0;

    }

    @Override
    public boolean deleteWeeklyExamById(Integer examId) {
        return weeklyExamMapper.deleteWeeklyExamById(examId)>0;
    }
}
