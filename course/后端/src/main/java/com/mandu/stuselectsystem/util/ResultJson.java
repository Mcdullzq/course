package com.mandu.stuselectsystem.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultJson {
    private int code = 200;
    private String msg ="success";
    private Object data;
}
