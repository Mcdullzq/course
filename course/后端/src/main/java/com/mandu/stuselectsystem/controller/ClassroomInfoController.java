package com.mandu.stuselectsystem.controller;

import com.mandu.stuselectsystem.dto.ClassroomInfoDto;
import com.mandu.stuselectsystem.service.ClassroomInfoService;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/ClassroomInfoController")
public class ClassroomInfoController {

    @Resource
    private ClassroomInfoService classroomInfoService;

    @RequestMapping("/save")
    public ResultJson save(@RequestBody ClassroomInfoDto classroomInfoDto){
        return classroomInfoService.doSave(classroomInfoDto);
    }

    @RequestMapping("/search")
    public ResultJson search(@RequestBody ClassroomInfoDto dto){
        return classroomInfoService.findByParam(dto);
    }

    @RequestMapping("/updateStatus")
    public ResultJson updateStatus(@RequestBody ClassroomInfoDto dto){
        return classroomInfoService.updateStatus(dto);
    }

    @RequestMapping("/update")
    public ResultJson update(@RequestBody ClassroomInfoDto dto){
        return classroomInfoService.doUpdate(dto);
    }

    @RequestMapping("/findAllLocation")
    public ResultJson findAllLocation(){
        return classroomInfoService.findAllLocation();
    }

    @RequestMapping("/findByLocation")
    public ResultJson findByLocation(@RequestBody ClassroomInfoDto dto){
        return classroomInfoService.findByLocation(dto);
    }
}
