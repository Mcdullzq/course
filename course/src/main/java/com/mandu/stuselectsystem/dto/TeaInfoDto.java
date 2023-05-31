package com.mandu.stuselectsystem.dto;

import com.mandu.stuselectsystem.po.TeaInfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeaInfoDto extends TeaInfo {
    private String loginName;
    private String loginPwd;
    private String teaOldPwd;
}
