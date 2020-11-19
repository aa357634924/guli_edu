package com.rj.eduservice.scheduled;

import com.rj.eduservice.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * TODO
 *  定时器任务
 * @author rj
 * @version 1.0
 * @date 2020-11-09 12:07
 */
//@Component
public class ScheduledTest {
    @Autowired
    private CourseMapper courseMapper;

    private static int num;

    @Scheduled(cron = "0/5 * * * * ?")
    public void testScheduled() {
        Integer integer = courseMapper.selectCount(null);
        System.out.println("第" + ++num + integer);
    }
}
