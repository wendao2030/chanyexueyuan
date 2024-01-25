package com.mhys.cyxy.controller;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.PracticalTask;
import com.mhys.cyxy.domain.ResponseData;
import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.dto.VideoDTO;
import com.mhys.cyxy.domain.vo.PracticalTaskVO;
import com.mhys.cyxy.domain.vo.VideoVO;
import com.mhys.cyxy.domain.vo.WeeklyExamVO;
import com.mhys.cyxy.service.IPracticalTaskService;
import com.mhys.cyxy.service.IWeeklyExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/liuzhi")
public class PracticalTaskController {

    @Autowired
    private IPracticalTaskService practicalTaskService;

    @RequestMapping("/getTaskResultByClasses")
    @ResponseBody
    public List<PracticalTaskVO> getTaskResultByClasses(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId) {
        return practicalTaskService.getTaskResultByClasses(termId, weekId);
    }

    @ResponseBody
    @PostMapping("/selectAllTaskResultByPage")
    public ResponseData<PageInfo<PracticalTaskVO>> selectAllTaskResultByPage(@RequestBody PracticalTaskDTO practicalTaskDTO){
        PageInfo<PracticalTaskVO> pageInfo = practicalTaskService.selectAllTaskResultByPage(practicalTaskDTO);
        return new ResponseData<>(pageInfo);
    }

    /*新增和修改一条记录*/
    @ResponseBody
    @PostMapping("/addPracticalTask")
    public ResponseData<Object> addPracticalTask(@RequestBody PracticalTask practicalTask){
        boolean result = practicalTaskService.addPracticalTask(practicalTask);
        return new ResponseData<>(result);
    }

    /*根据id查询*/
    @ResponseBody
    @RequestMapping("/selectTaskResultById")
    public ResponseData<PracticalTaskVO> selectTaskResultById(@RequestParam(value = "practicalTaskId",required = true) Integer practicalTaskId){
        PracticalTaskVO practicalTaskVO = practicalTaskService.selectTaskResultById(practicalTaskId);
        log.info("根据id查询实践练习完成情况");
        return new ResponseData<>(practicalTaskVO);
    }

    /*根据id删除*/
    @ResponseBody
    @PostMapping("/deletePracticalTaskById")
    public ResponseData<Object> deletePracticalTaskById(@RequestParam(value = "practicalTaskId",required = true) Integer practicalTaskId){
        boolean result = practicalTaskService.deletePracticalTaskById(practicalTaskId);
        if(result){
            log.warn("删除一条实践练习完成情况");
        }
        return new ResponseData<>(result);
    }
}
