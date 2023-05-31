package com.mandu.stuselectsystem.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StuInfo {
    private Integer stuId;
    private String stuName;
    private Integer stuSex;
    private String stuPwd;
    private String stuEmail;
    private Integer stuStatus;
    private String stuImage;
}
