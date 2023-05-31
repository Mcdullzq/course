package com.mandu.stuselectsystem.dto;

import com.mandu.stuselectsystem.po.StuInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StuInfoDto extends StuInfo {
    private String LoginName;
    private String LoginPwd;
    private String oldPwd;
}
