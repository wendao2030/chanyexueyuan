package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.dto.VideoDTO;
import com.mhys.cyxy.domain.vo.VideoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface VideoMapper {
    /*查询一周总体moot观看率*/
    public VideoVO getAllVideoRate(@Param("termId") Integer termId, @Param("weekId") Integer weekId);

    /*按班级查看一周moot观看率*/
    public List<VideoVO> getVideoRateByClasses(@Param("termId") Integer termId, @Param("weekId") Integer weekId);

    /*分年级查询一周moot观看率*/
    public List<VideoVO> getVideoRateByGrade(@Param("termId") Integer termId, @Param("weekId") Integer weekId);

    /*分科目查询moot观看率*/
    public List<VideoVO> getVideoRateByCourse(@Param("gradeId") Integer gradeId);

    public int getMaxTermId();
    public Integer getMaxWeekId();

    /*条件分页查询所有moot观看情况*/
    List<VideoVO> selectAllVideoByPage(VideoDTO videoDTO);

    /*插入一条记录*/
    public int addVideo(Video video);

    /*根据id查询video*/
    VideoVO selectVideoById(@Param("videoId") Integer videoId);

    /*修改*/
    public int updateVideo(Video video);

    /*删除*/
    public int deleteVideoById(@Param("videoId") Integer videoId);
}
