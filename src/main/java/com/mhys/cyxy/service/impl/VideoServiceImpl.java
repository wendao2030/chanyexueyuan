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
    public VideoVO getAllVideoRate(LocalDate beginTime, LocalDate endTime) {
        return videoMapper.getAllVideoRate(beginTime,endTime);
    }

    @Override
    public List<VideoVO> getVideoRateByGrade(LocalDate beginTime, LocalDate endTime) {
        return videoMapper.getVideoRateByGrade(beginTime, endTime);
    }

    @Override
    public List<VideoVO> getVideoRateByCourse(Integer gradeId) {
        return videoMapper.getVideoRateByCourse(gradeId);
    }
}
