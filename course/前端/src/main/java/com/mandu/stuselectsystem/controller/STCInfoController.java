package com.mandu.stuselectsystem.controller;

import com.mandu.stuselectsystem.service.STCInfoService;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/STCInfoController")
public class STCInfoController {

    @Resource
    private STCInfoService stcInfoService;
    @RequestMapping("/findByParam")
    public ResultJson findByParam(@RequestBody Map<String,String> map){
        return stcInfoService.findByParam(map);
    }

    @RequestMapping("/updateScore")
    public ResultJson updateScore(@RequestBody Map<String,String> map){
        return stcInfoService.updateScore(map);
    }

    @RequestMapping("/findUnSelectedCourse")
    public ResultJson findUnSelectedCourse(@RequestBody Map<String,String> map){
        return stcInfoService.findUnSelectedCourse(map);
    }

    @RequestMapping("/save")
    public ResultJson save(@RequestBody Map<String,String> map){
        return stcInfoService.save(map);
    }

    @RequestMapping("/findSelectedCourse")
    public ResultJson findSelectedCourse(@RequestBody Map<String,String> map){
        return stcInfoService.findSelectedCourse(map);
    }

    @RequestMapping("/delete")
    public ResultJson delete(@RequestBody Map<String,String> map){
        return stcInfoService.delete(map);
    }
}
