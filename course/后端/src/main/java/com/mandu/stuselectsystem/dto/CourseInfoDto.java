package com.mandu.stuselectsystem.dto;

import com.mandu.stuselectsystem.po.CourseInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseInfoDto extends CourseInfo {
    private Integer minCredit;
    private Integer maxCredit;

}
