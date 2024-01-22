package com.mhys.cyxy.service.impl;

import com.mhys.cyxy.domain.vo.VideoVO;
import com.mhys.cyxy.mapper.VideoMapper;
import com.mhys.cyxy.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class VideoServiceImpl implements IVideoService {

    @Resource
    private VideoMapper videoMapper;

    @Override
    public VideoVO getAllVideoRate(Integer termId, Integer weekId) {
        if(termId == null){
            termId = videoMapper.getMaxTermId();
        }
        if(weekId == null){
            weekId = videoMapper.getMaxWeekId();
        }
        return videoMapper.getAllVideoRate(termId,weekId);
    }

    @Override
    public List<VideoVO> getVideoRateByClasses(Integer termId, Integer weekId) {
        if(termId == null){
            termId = videoMapper.getMaxTermId();
        }
        if(weekId == null){
            weekId = videoMapper.getMaxWeekId();
        }
        return videoMapper.getVideoRateByClasses(termId,weekId);
    }

    @Override
    public List<VideoVO> getVideoRateByGrade(Integer termId, Integer weekId) {
        if(termId == null){
            termId = videoMapper.getMaxTermId();
        }
        if(weekId == null){
            weekId = videoMapper.getMaxWeekId();
        }
        return videoMapper.getVideoRateByGrade(termId,weekId);
    }

    @Override
    public List<VideoVO> getVideoRateByCourse(Integer gradeId) {
        return videoMapper.getVideoRateByCourse(gradeId);
    }
}
