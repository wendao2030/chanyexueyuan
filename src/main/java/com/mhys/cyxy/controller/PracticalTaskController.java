package com.mhys.cyxy.controller;

import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import com.mhys.cyxy.service.IPracticalTaskService;
import com.mhys.cyxy.service.IWeeklyExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class PracticalTaskController {

    @Autowired
    private IPracticalTaskService practicalExamService;

    @RequestMapping("/getTaskResultByClasses")
    @ResponseBody
    public List<PracticalTaskVO> getTaskResultByClasses(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId) {
        return practicalExamService.getTaskResultByClasses(termId, weekId);
    }

}
