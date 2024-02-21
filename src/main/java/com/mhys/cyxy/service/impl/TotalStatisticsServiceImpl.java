package com.mhys.cyxy.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.mhys.cyxy.domain.Lecturer;
import com.mhys.cyxy.domain.vo.*;
import com.mhys.cyxy.mapper.*;
import com.mhys.cyxy.service.ITotalStatisticsService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Service
public class TotalStatisticsServiceImpl implements ITotalStatisticsService {
    @Resource
    private AttendanceMapper attendanceMapper;

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private PracticalTaskMapper practicalTaskMapper;

    @Resource
    private WeeklyExamMapper weeklyExamMapper;

    @Resource
    private TutorEventMapper tutorEventMapper;

    @Resource
    private StudentActivityMapper studentActivityMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private ChapterMapper chapterMapper;

    @Resource
    private TermMapper termMapper;

    @Resource
    private WeekMapper weekMapper;

    @Resource
    private TutorMapper tutorMapper;

    @Resource
    private LecturerMapper lecturerMapper;

    @Resource
    private ClassesMapper classesMapper;

    @Resource
    private GradeMapper gradeMapper;

    @Override
    public Map<String, Object> getTotalStatistics() throws Exception {
        Map<String, Object> map = new HashMap<>();
        //查询一周出勤率
        ZoneId zoneId = ZoneId.systemDefault();
        //atZone()方法返回在指定时区,从该Instant生成的ZonedDateTime
        Date lastDay = attendanceMapper.getLastDay();
        ZonedDateTime zonedDateTime1 = lastDay.toInstant().atZone(zoneId);
        ZonedDateTime zonedDateTime2 = zonedDateTime1.minusDays(7);
        AttendanceVO attendanceVO = attendanceMapper.getAllAttendance(zonedDateTime2.toLocalDate(), zonedDateTime1.toLocalDate());
        if (attendanceVO != null) {
            map.put("attendance", attendanceVO.getRate());
        } else {
            map.put("attendance", null);
        }

        //查询moot观看率
        VideoVO videoVO = videoMapper.getAllVideoRate(videoMapper.getMaxTermId(), videoMapper.getMaxWeekId());
        if (videoVO != null) {
            map.put("video", videoVO.getRate());
        } else {
            map.put("video", null);
        }

        //查询实践课完成率
        PracticalTaskVO practicalTaskVO = practicalTaskMapper.getAllTaskResult(practicalTaskMapper.getMaxTermId(), practicalTaskMapper.getMaxWeekId());
        if (practicalTaskVO != null) {
            map.put("praticalTask", practicalTaskVO.getRate());
        } else {
            map.put("praticalTask", null);
        }

        //查询周测合格率
        WeeklyExamVO weeklyExamVO = weeklyExamMapper.getAllExamResult(weeklyExamMapper.getMaxTermId(), weeklyExamMapper.getMaxWeekId());
        if (weeklyExamVO != null) {
            map.put("weeklyExam", weeklyExamVO.getRate());
        } else {
            map.put("weeklyExam", null);
        }

        //查询班主任处理事件总数量
        TutorEventVO tutorEventVO = tutorEventMapper.getAllCount();
        if (tutorEventVO != null) {
            map.put("eventNum", tutorEventVO.getEventNum());
        } else {
            map.put("eventNum", null);
        }

        //查询学生活动总数量
        StudentActivityVO studentActivityVO = studentActivityMapper.getAllCount();
        if (studentActivityVO != null) {
            map.put("activityNum", studentActivityVO.getActivityNum());
        } else {
            map.put("activityNum", null);
        }

        return map;
    }

    @Override
    public JSONObject getDicMsg() {
        List<Map<String, Object>> courseMapList = courseMapper.getDicMsg();
        List<Map<String, Object>> chapterMapList = chapterMapper.getDicMsg();
        List<Map<String, Object>> termMapList = termMapper.getDicMsg();
        List<Map<String, Object>> weekMapList = weekMapper.getDicMsg();
        List<Map<String, Object>> tutorMapList = tutorMapper.getDicMsg();
        List<Map<String, Object>> lecturerMapList = lecturerMapper.getDicMsg();
        List<Map<String, Object>> classesMapList = classesMapper.getDicMsg();
        List<Map<String, Object>> gradeMapList = gradeMapper.getDicMsg();

        Map<String, List<Map<String, Object>>> map = new HashMap<>();
        map.put("course", courseMapList);
        map.put("chapter", chapterMapList);
        map.put("term", termMapList);
        map.put("week", weekMapList);
        map.put("tutor", tutorMapList);
        map.put("lecturer", lecturerMapList);
        map.put("classes", classesMapList);
        map.put("grade", gradeMapList);
        JSONObject json = new JSONObject(map);

        return json;
    }


}
