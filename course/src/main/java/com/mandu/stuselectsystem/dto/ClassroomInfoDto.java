package com.mandu.stuselectsystem.dto;

import com.mandu.stuselectsystem.po.ClassroomInfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClassroomInfoDto extends ClassroomInfo {
    private Integer minNumber;
    private Integer maxNumber;
    private String classId;

}
