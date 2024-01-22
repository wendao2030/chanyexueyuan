package com.mhys.cyxy.controller;

import com.mhys.cyxy.domain.vo.StudentActivityVO;
import com.mhys.cyxy.domain.vo.TutorEventVO;
import com.mhys.cyxy.service.IStudentActivityService;
import com.mhys.cyxy.service.ITutorEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class StudentActivityController {

    @Autowired
    private IStudentActivityService studentActivityService;

    @RequestMapping("/getStudentActivityAllCount")
    @ResponseBody
    public StudentActivityVO getAllCount() {
        return studentActivityService.getAllCount();
    }
}
