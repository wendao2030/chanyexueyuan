package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.vo.VideoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface VideoMapper {
    /*查询本周总体moot观看率*/
    public VideoVO getAllVideoRate(@Param("beginTime") LocalDate beginTime, @Param("endTime") LocalDate endTime);

    /*按班级查看本周moot观看率*/
    public List<VideoVO> getVideoRateByClasses(@Param("beginTime") LocalDate beginTime, @Param("endTime") LocalDate endTime);

    /*分年级查询本周moot观看率*/
    public List<VideoVO> getVideoRateByGrade(@Param("beginTime") LocalDate beginTime, @Param("endTime") LocalDate endTime);

    /*分科目查询moot观看率*/
    public List<VideoVO> getVideoRateByCourse(@Param("gradeId") Integer gradeId);

}
