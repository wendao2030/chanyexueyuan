package com.mhys.cyxy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.dto.VideoDTO;
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

    @Override
    public PageInfo<VideoVO> selectAllVideoByPage(VideoDTO videoDTO) {
        PageHelper.startPage(videoDTO.getPageNum(), videoDTO.getPageSize());
        List<VideoVO> list = videoMapper.selectAllVideoByPage(videoDTO);
        return new PageInfo<>(list);
    }

    @Override
    public boolean addVideo(Video video) {
        if(video.getVideoId() != null) {
            VideoVO vo = videoMapper.selectVideoById(video.getVideoId());
            if(vo != null){
                //修改
                return videoMapper.updateVideo(video) > 0;
            }
        }
        //新增
        return videoMapper.addVideo(video) >0;
    }

    @Override
    public boolean deleteVideoById(Integer videoId) {
        return videoMapper.deleteVideoById(videoId) > 0;
    }

    @Override
    public VideoVO selectVideoById(Integer videoId) {
        return videoMapper.selectVideoById(videoId);
    }


}
