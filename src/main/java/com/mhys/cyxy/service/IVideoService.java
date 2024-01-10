package com.mhys.cyxy.service;

import com.mhys.cyxy.domain.vo.VideoVO;

import java.time.LocalDate;
import java.util.List;

public interface IVideoService {
    public VideoVO getAllVideoRate(LocalDate beginTime, LocalDate endTime);
    public List<VideoVO> getVideoRateByGrade(LocalDate beginTime, LocalDate endTime);
    public List<VideoVO> getVideoRateByCourse(Integer gradeId);
}
