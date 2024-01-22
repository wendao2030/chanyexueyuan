package com.mhys.cyxy.service.impl;

import com.mhys.cyxy.domain.vo.StudentActivityVO;
import com.mhys.cyxy.mapper.StudentActivityMapper;
import com.mhys.cyxy.service.IStudentActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentActivityServiceImpl implements IStudentActivityService {
    @Resource
    private StudentActivityMapper studentActivityMapper;

    @Override
    public StudentActivityVO getAllCount() {
        return studentActivityMapper.getAllCount();
    }
}
