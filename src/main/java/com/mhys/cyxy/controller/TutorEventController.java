package com.mhys.cyxy.controller;

import com.mhys.cyxy.domain.ResponseData;
import com.mhys.cyxy.domain.vo.TutorEventVO;
import com.mhys.cyxy.service.ITotalStatisticsService;
import com.mhys.cyxy.service.ITutorEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class TutorEventController {

    @Autowired
    private ITutorEventService tutorEventService;

    @RequestMapping("/getTutorEventCountByTutor")
    @ResponseBody
    public ResponseData<List<TutorEventVO>> getCountByTutor() {
        try {
            List<TutorEventVO> list = tutorEventService.getCountByTutor();
            log.info("查询班主任事件成功");
            return new ResponseData<>(list);
        }catch (Exception e){
            log.error("查询班主任事件接口失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @RequestMapping("/getTutorEventAllCount")
    @ResponseBody
    public ResponseData<TutorEventVO> getAllCount() {
        try {
            TutorEventVO vo = tutorEventService.getAllCount();
            log.info("查询班主任事件数量成功");
            return new ResponseData<>(vo);
        }catch (Exception e){
            log.error("查询班主任事件数量接口失败");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }
}
