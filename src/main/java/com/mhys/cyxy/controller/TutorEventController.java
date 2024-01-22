package com.mhys.cyxy.controller;

import com.mhys.cyxy.domain.vo.TutorEventVO;
import com.mhys.cyxy.service.ITotalStatisticsService;
import com.mhys.cyxy.service.ITutorEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class TutorEventController {

    @Autowired
    private ITutorEventService tutorEventService;

    @RequestMapping("/getTutorEventCountByTutor")
    @ResponseBody
    public List<TutorEventVO> getCountByTutor() {
        return tutorEventService.getCountByTutor();
    }

    @RequestMapping("/getTutorEventAllCount")
    @ResponseBody
    public TutorEventVO getAllCount() {
        return tutorEventService.getAllCount();
    }
}
