package com.mandu.stuselectsystem.service;

import com.mandu.stuselectsystem.dto.CourseInfoDto;
import com.mandu.stuselectsystem.mapper.CourseInfoMapper;
import com.mandu.stuselectsystem.po.CourseInfo;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInfoService {
    @Resource
    private CourseInfoMapper courseInfoMapper;

    public ResultJson doSave(CourseInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = courseInfoMapper.save(dto);
        if(row==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
    public ResultJson findByParam(CourseInfoDto dto){
        ResultJson rst = new ResultJson();
        List<CourseInfo> list = courseInfoMapper.findByParam(dto);
        rst.setData(list);
        return rst;
    }

    public ResultJson doDelete(CourseInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = courseInfoMapper.updateStatus(dto);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst ;
    }

    public ResultJson resetCourseStatus(int[] ids){
        ResultJson rst = new ResultJson();
        int row = courseInfoMapper.resetCourseStatus(ids);
        if(row ==0){
            rst.setCode(500);
            rst .setMsg("error");
        }
        return rst;
    }

    public ResultJson doUpdate(CourseInfoDto dto) {
        ResultJson rst=new ResultJson();
        int row=courseInfoMapper.update(dto);
        if(row==0) {
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
}
