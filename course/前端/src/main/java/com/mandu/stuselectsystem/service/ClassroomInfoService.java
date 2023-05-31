package com.mandu.stuselectsystem.service;

import com.mandu.stuselectsystem.dto.ClassroomInfoDto;
import com.mandu.stuselectsystem.mapper.ClassroomMapper;
import com.mandu.stuselectsystem.po.ClassroomInfo;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomInfoService {
    @Resource
    private ClassroomMapper classroomMapper;

    public ResultJson doSave(ClassroomInfoDto dto){
        ResultJson rst  = new ResultJson();
        int row= classroomMapper.save(dto);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }

    public ResultJson findByParam(ClassroomInfoDto dto){
        ResultJson rst = new ResultJson();
        List<ClassroomInfo> list = classroomMapper.findByParam(dto);
        rst.setData(list);
        return rst;
    }
    public ResultJson updateStatus(ClassroomInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = classroomMapper.updateStatus(dto);
        if(row==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }

    public ResultJson doUpdate(ClassroomInfoDto dto){
        ResultJson rst = new ResultJson();
        int row =classroomMapper.update(dto);
        if(row == 0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
    public ResultJson findAllLocation(){
        ResultJson rst = new ResultJson();
        List<ClassroomInfo> list = classroomMapper.findAllLocation();
        rst.setData(list);
        return rst;
    }
    public ResultJson findByLocation(ClassroomInfoDto dto){
        ResultJson rst = new ResultJson();
        List<ClassroomInfo> list = classroomMapper.findByLocation(dto);
        rst.setData(list);
        return rst;
    }
}
