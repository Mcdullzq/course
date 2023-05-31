package com.mandu.stuselectsystem.po;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseInfo {
    private Integer courseId;
    private String courseName;
    private Integer courseCredit;
    private Integer courseExamMethod;
    private Integer courseStatus;
}
