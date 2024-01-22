package com.mhys.cyxy.mapper;

import com.mhys.cyxy.domain.vo.StudentActivityVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentActivityMapper {
    public StudentActivityVO getAllCount();
}
