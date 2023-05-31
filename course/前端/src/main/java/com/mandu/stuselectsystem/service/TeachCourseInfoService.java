package com.mandu.stuselectsystem.service;

import com.mandu.stuselectsystem.dto.TeachCourseInfoDto;
import com.mandu.stuselectsystem.mapper.TeachCourseInfoMapper;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeachCourseInfoService {

    @Resource
    private TeachCourseInfoMapper teachCourseInfoMapper;

    public ResultJson save(TeachCourseInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = teachCourseInfoMapper.save(dto);
        if(row == 0 ){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
    public ResultJson findByParam(TeachCourseInfoDto dto){
        ResultJson rst = new ResultJson();
        List<Map<String, Object>> map = teachCourseInfoMapper.findByParam(dto);
        rst.setData(map);
        return rst;
    }

    public ResultJson doDelete(TeachCourseInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = teachCourseInfoMapper.delete(dto);
        if(row == 0 ){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
}
