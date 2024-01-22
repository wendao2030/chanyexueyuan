package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.vo.TutorEventVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TutorEventMapper {

    /*查询每个班主任的处理事件次数*/
    public List<TutorEventVO> getCountByTutor();

    /*查询总的班主任处理事件次数*/
    public TutorEventVO getAllCount();
}

