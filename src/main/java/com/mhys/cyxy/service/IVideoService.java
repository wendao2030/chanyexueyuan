package com.mhys.cyxy.service;

import com.mhys.cyxy.domain.vo.VideoVO;

import java.time.LocalDate;
import java.util.List;

public interface IVideoService {
    public VideoVO getAllVideoRate(Integer termId, Integer weekId);
    public List<VideoVO> getVideoRateByClasses(Integer termId, Integer weekId);
    public List<VideoVO> getVideoRateByGrade(Integer termId, Integer weekId);
    public List<VideoVO> getVideoRateByCourse(Integer gradeId);
}
