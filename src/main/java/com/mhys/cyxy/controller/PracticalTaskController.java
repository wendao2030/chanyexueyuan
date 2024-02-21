package com.mhys.cyxy.controller;

import com.github.pagehelper.PageInfo;
import com.mhys.cyxy.domain.PracticalTask;
import com.mhys.cyxy.domain.ResponseData;
import com.mhys.cyxy.domain.Video;
import com.mhys.cyxy.domain.dto.PracticalTaskDTO;
import com.mhys.cyxy.domain.dto.VideoDTO;
import com.mhys.cyxy.domain.vo.AttendanceVO;
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
    public ResponseData<List<PracticalTaskVO>> getTaskResultByClasses(@RequestParam(value = "termId", required = false) Integer termId, @RequestParam(value = "weekId", required = false) Integer weekId) {
        try {
            List<PracticalTaskVO> list = practicalTaskService.getTaskResultByClasses(termId, weekId);
            log.info("按班级查询实践任务完成情况成功");
            return new ResponseData<>(list);
        } catch (Exception e) {
            log.error("按班级查询实践任务完成情况接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    @ResponseBody
    @PostMapping("/selectAllTaskResultByPage")
    public ResponseData<PageInfo<PracticalTaskVO>> selectAllTaskResultByPage(@RequestBody PracticalTaskDTO practicalTaskDTO){
        try {
            PageInfo<PracticalTaskVO> pageInfo = practicalTaskService.selectAllTaskResultByPage(practicalTaskDTO);
            log.info("条件查询实践任务完成情况成功");
            return new ResponseData<>(pageInfo);
        }catch (Exception e){
            log.error("条件查询实践任务完成情况接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }

    }

    /*新增和修改一条记录*/
    @ResponseBody
    @PostMapping("/addPracticalTask")
    public ResponseData<Object> addPracticalTask(@RequestBody PracticalTask practicalTask){
        try {
            if(practicalTask.getClassesId()==null || practicalTask.getChapterId()==null ||
                    practicalTask.getTermId() == null || practicalTask.getWeekId() == null||
                    practicalTask.getTutorId() == null || practicalTask.getLecturerId() ==null)
            {
                return  ResponseData.fail("参数传递缺失");
            }
            boolean result = practicalTaskService.addPracticalTask(practicalTask);
            if (result){
                log.info("新增一条实践任务完成情况成功");
                return new ResponseData<>(result);
            }else {
                log.warn("新增一条实践任务完成情况失败");
                return ResponseData.fail();
            }
        }catch (Exception e){
            log.error("新增一条实践任务完成情况接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*根据id查询*/
    @ResponseBody
    @RequestMapping("/selectTaskResultById")
    public ResponseData<PracticalTaskVO> selectTaskResultById(@RequestParam(value = "practicalTaskId",required = true) Integer practicalTaskId){
        try {
            PracticalTaskVO practicalTaskVO = practicalTaskService.selectTaskResultById(practicalTaskId);
            log.info("根据id查询实践练习完成情况");
            return new ResponseData<>(practicalTaskVO);
        }catch (Exception e){
            log.error("根据id查询实践任务完成情况接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }

    /*根据id删除*/
    @ResponseBody
    @PostMapping("/deletePracticalTaskById")
    public ResponseData<Object> deletePracticalTaskById(@RequestParam(value = "practicalTaskId",required = true) Integer practicalTaskId){
        try {
            boolean result = practicalTaskService.deletePracticalTaskById(practicalTaskId);
            if (result){
                log.info("根据id删除一条实践任务完成情况成功");
                return new ResponseData<>(result);
            }else {
                log.info("根据id删除一条实践任务完成情况失败");
                return ResponseData.fail();
            }
        }catch (Exception e){
            log.error("根据id删除一条实践任务完成情况接口报错");
            log.error(e.getMessage());
            return ResponseData.error();
        }
    }
}
