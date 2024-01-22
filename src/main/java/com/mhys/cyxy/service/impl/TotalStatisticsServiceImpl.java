package com.mhys.cyxy.service.impl;

import com.mhys.cyxy.domain.vo.*;
import com.mhys.cyxy.mapper.*;
import com.mhys.cyxy.service.ITotalStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TotalStatisticsServiceImpl implements ITotalStatisticsService {
    @Resource
    private AttendanceMapper attendanceMapper;

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private PraticalTaskMapper praticalTaskMapper;

    @Resource
    private WeeklyExamMapper weeklyExamMapper;

    @Resource
    private TutorEventMapper tutorEventMapper;

    @Resource
    private StudentActivityMapper studentActivityMapper;

    @Override
    public Map<String, Object> getTotalStatistics() {
        Map<String, Object> map = new HashMap<>();
        //查询一周出勤率
        ZoneId zoneId = ZoneId.systemDefault();
        //atZone()方法返回在指定时区,从该Instant生成的ZonedDateTime
        Date lastDay = attendanceMapper.getLastDay();
        ZonedDateTime zonedDateTime1 = lastDay.toInstant().atZone(zoneId);
        ZonedDateTime zonedDateTime2 = zonedDateTime1.minusDays(7);
        AttendanceVO attendanceVO = attendanceMapper.getAllAttendance(zonedDateTime2.toLocalDate(), zonedDateTime1.toLocalDate());
        map.put("attendance",attendanceVO.getRate());

        //查询moot观看率
        VideoVO videoVO = videoMapper.getAllVideoRate(videoMapper.getMaxTermId(),videoMapper.getMaxWeekId());
        map.put("video",videoVO.getRate());

        //查询实践课完成率
        PracticalTaskVO practicalTaskVO =  praticalTaskMapper.getAllTaskResult(praticalTaskMapper.getMaxTermId(),praticalTaskMapper.getMaxWeekId());
        map.put("praticalTask",practicalTaskVO.getRate());

        //查询周测合格率
        WeeklyExamVO weeklyExamVO = weeklyExamMapper.getAllExamResult(weeklyExamMapper.getMaxTerm(),weeklyExamMapper.getMaxWeek());
        map.put("weeklyExam",weeklyExamVO.getRate());

        //查询班主任处理事件总数量
        TutorEventVO tutorEventVO = tutorEventMapper.getAllCount();
        map.put("eventNum",tutorEventVO.getEventNum());

        //查询学生活动总数量
        StudentActivityVO studentActivityVO = studentActivityMapper.getAllCount();
        map.put("activityNum",studentActivityVO.getActivityNum());

        return map;
    }
}
