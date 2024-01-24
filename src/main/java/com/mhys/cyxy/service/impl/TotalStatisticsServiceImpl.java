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
    private PraticalTaskMapper praticalTaskMapper;

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

    @Override
    public JSONObject getDicMsg() {
        List<Map<String, Object>> courseMapList = courseMapper.getDicMsg();
        List<Map<String, Object>> chapterMapList =  chapterMapper.getDicMsg();
        List<Map<String, Object>> termMapList =  termMapper.getDicMsg();
        List<Map<String, Object>> weekMapList =  weekMapper.getDicMsg();
        List<Map<String, Object>> tutorMapList =  tutorMapper.getDicMsg();
        List<Map<String, Object>> lecturerMapList =  lecturerMapper.getDicMsg();
        List<Map<String, Object>> classesMapList =  classesMapper.getDicMsg();
        List<Map<String, Object>> gradeMapList =  gradeMapper.getDicMsg();

        Map<String,List<Map<String, Object>>> map = new HashMap<>();
        map.put("course", courseMapList);
        map.put("chapter", chapterMapList);
        map.put("term", termMapList);
        map.put("week", weekMapList);
        map.put("tutor", tutorMapList);
        map.put("lecturer", lecturerMapList);
        map.put("classes", classesMapList);
        map.put("grade", gradeMapList);
        JSONObject json = new JSONObject(map);

//        List<Map<Integer, String>> list = new ArrayList<>();
//
//        Map<Integer,String> newCourseMap = new HashMap<>();
//        for(Map<String,Object> map: courseMapList){
//            int course_id = (int)map.get("course_id");
//            String course_name = (String)map.get("course_name");
//            newCourseMap.put(course_id, course_name);
//        }
//        list.add(newCourseMap);
//
//        Map<Integer,String> newChapterMap = new HashMap<>();
//        for(Map<String,Object> map: chapterMapList){
//            int chapter_id = (int)map.get("chapter_id");
//            String chapter_name = (String)map.get("chapter_name");
//            newChapterMap.put(chapter_id, chapter_name);
//        }
//        list.add(newChapterMap);
//
//        Map<Integer,String> newTermMap = new HashMap<>();
//        for(Map<String,Object> map: termMapList){
//            int term_id = (int)map.get("term_id");
//            String term_name = (String)map.get("term_name");
//            newTermMap.put(term_id, term_name);
//        }
//        list.add(newTermMap);
//
//        Map<Integer,String> newWeekMap = new HashMap<>();
//        for(Map<String,Object> map: weekMapList){
//            int week_id = (int)map.get("week_id");
//            String week_name = (String)map.get("week_name");
//            newWeekMap.put(week_id, week_name);
//        }
//        list.add(newWeekMap);
//
//        Map<Integer,String> newTutorMap = new HashMap<>();
//        for(Map<String,Object> map: tutorMapList){
//            int tutor_id = (int)map.get("tutor_id");
//            String tutor_name = (String)map.get("tutor_name");
//            newTutorMap.put(tutor_id, tutor_name);
//        }
//        list.add(newTutorMap);
//
//        Map<Integer,String> newLecturerMap = new HashMap<>();
//        for(Map<String,Object> map: lecturerMapList){
//            int lecturer_id = (int)map.get("lecturer_id");
//            String lecturer_name = (String)map.get("lecturer_name");
//            newLecturerMap.put(lecturer_id, lecturer_name);
//        }
//        list.add(newLecturerMap);
//
//        Map<Integer,String> newClassesMap = new HashMap<>();
//        for(Map<String,Object> map: classesMapList){
//            int classes_id = (int)map.get("classes_id");
//            String classes_name = (String)map.get("classes_name");
//            newClassesMap.put(classes_id, classes_name);
//        }
//        list.add(newClassesMap);
//
//        Map<Integer,String> newGradeMap = new HashMap<>();
//        for(Map<String,Object> map: gradeMapList){
//            int grade_id = (int)map.get("grade_id");
//            String grade_name = (String)map.get("grade_name");
//            newGradeMap.put(grade_id, grade_name);
//        }
//        list.add(newGradeMap);

        return json;
    }


}
