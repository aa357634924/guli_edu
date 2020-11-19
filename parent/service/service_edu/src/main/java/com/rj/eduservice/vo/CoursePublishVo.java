package com.rj.eduservice.vo;

import lombok.Data;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-05 17:41
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
