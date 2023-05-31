package com.mandu.stuselectsystem.service;

import com.mandu.stuselectsystem.dto.CourseInfoDto;
import com.mandu.stuselectsystem.dto.TeaInfoDto;
import com.mandu.stuselectsystem.mapper.TeaInfoMapper;
import com.mandu.stuselectsystem.po.TeaInfo;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaInfoService {
    @Resource
    private TeaInfoMapper teaInfoMapper;

    public ResultJson login(TeaInfoDto dto){
        ResultJson rst = new ResultJson();
        TeaInfo tea = teaInfoMapper.login(dto);
        rst.setData(tea);
        return rst;
    }

    public ResultJson doSave(TeaInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = teaInfoMapper.save(dto);
        if(row == 0 ){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }

    public ResultJson findByParam(TeaInfoDto dto){
        ResultJson rst = new ResultJson();
        List<TeaInfo> list = teaInfoMapper.findByParam(dto);
        rst.setData(list);
        return rst;
    }
    public ResultJson doDelete(TeaInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = teaInfoMapper.delete(dto);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
    public ResultJson update(TeaInfoDto dto){
        ResultJson rst= new ResultJson();
        int row = teaInfoMapper.update(dto);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }

    public ResultJson findByCourseId(CourseInfoDto dto){
        ResultJson rst = new ResultJson();
        List<TeaInfo> list = teaInfoMapper.findByCourseId(dto);
        rst.setData(list);
        return rst ;
    }
    public ResultJson updatePwd(TeaInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = teaInfoMapper.updatePwd(dto);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst ;
    }
}
