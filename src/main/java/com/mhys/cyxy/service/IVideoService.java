package com.mhys.cyxy.service;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.dto.VideoDTO;
import com.mhys.cyxy.domain.vo.VideoVO;

import java.time.LocalDate;
import java.util.List;

public interface IVideoService {
    public VideoVO getAllVideoRate(Integer termId, Integer weekId);
    public List<VideoVO> getVideoRateByClasses(Integer termId, Integer weekId);
    public List<VideoVO> getVideoRateByGrade(Integer termId, Integer weekId);
    public List<VideoVO> getVideoRateByCourse(Integer gradeId);
    PageInfo<VideoVO> selectAllVideoByPage(VideoDTO videoDTO);
    boolean addVideo(Video video);
    boolean deleteVideoById(Integer videoId);
    VideoVO selectVideoById(Integer videoId);
}
