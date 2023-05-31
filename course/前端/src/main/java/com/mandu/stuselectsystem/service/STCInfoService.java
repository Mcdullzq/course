package com.mandu.stuselectsystem.service;

import com.mandu.stuselectsystem.mapper.STCInfoMapper;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class STCInfoService {
    @Resource
    private STCInfoMapper stcInfoMapper;

    public ResultJson findByParam(Map<String,String> map){
        ResultJson rst = new ResultJson();
        List<Map<String,Object>> list =stcInfoMapper.findByParam(map);
        rst.setData(list);
        return rst ;
    }
    public ResultJson updateScore(Map<String,String> map){
        ResultJson rst = new ResultJson();
        int row  =stcInfoMapper.updateScore(map);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst ;
    }

    public ResultJson findUnSelectedCourse(Map<String,String> map){
        ResultJson rst = new ResultJson();
        List<Map<String,Object>> list  =stcInfoMapper.findUnSelectedCourse(map);
        rst.setData(list);
        return rst ;
    }
    public ResultJson save(Map<String,String> map){
        ResultJson rst = new ResultJson();
        int row = stcInfoMapper.save(map);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
    public ResultJson findSelectedCourse(Map<String,String> map){
        ResultJson rst = new ResultJson();
        List<Map<String,Object>> list= stcInfoMapper.findSelectedCourse(map);
        rst.setData(list);
        return rst;
    }
    public ResultJson delete(Map<String,String> map){
        ResultJson rst = new ResultJson();
        int row = stcInfoMapper.delete(map);
        if(row==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
}
