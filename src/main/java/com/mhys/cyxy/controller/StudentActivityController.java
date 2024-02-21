package com.mhys.cyxy.controller;

import com.mhys.cyxy.domain.ResponseData;
import com.mhys.cyxy.domain.vo.StudentActivityVO;
import com.mhys.cyxy.domain.vo.TutorEventVO;
import com.mhys.cyxy.service.IStudentActivityService;
import com.mhys.cyxy.service.ITutorEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class StudentActivityController {

    @Autowired
    private IStudentActivityService studentActivityService;

    @RequestMapping("/getStudentActivityAllCount")
    @ResponseBody
    public ResponseData<StudentActivityVO> getAllCount() {
        try {
            StudentActivityVO vo = studentActivityService.getAllCount();
            log.error("查询学生活动成功");
            return new ResponseData<>(vo);
        }catch (Exception e){
            log.error("查询学生活动接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }

    }
}
