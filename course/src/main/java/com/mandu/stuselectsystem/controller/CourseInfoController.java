package com.mandu.stuselectsystem.controller;

import com.mandu.stuselectsystem.dto.CourseInfoDto;
import com.mandu.stuselectsystem.service.CourseInfoService;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/CourseInfoController")
public class CourseInfoController {

    @Resource
    private CourseInfoService courseInfoService;

    @RequestMapping("/doSave")
    public ResultJson doSave(@RequestBody CourseInfoDto dto){
        return courseInfoService.doSave(dto);
    }
    @RequestMapping("/findByParam")
    public ResultJson findByParam(@RequestBody CourseInfoDto dto){
        return courseInfoService.findByParam(dto);
    }
    @RequestMapping("/doDelete")
    public ResultJson doDelete(@RequestBody CourseInfoDto dto){
        return courseInfoService.doDelete(dto);
    }
    @RequestMapping("/resetCourseStatus")
    public ResultJson resetCourseStatus(@RequestBody int[] ids){
        return courseInfoService.resetCourseStatus(ids);
    }
    @RequestMapping("/update")
    public ResultJson update(@RequestBody CourseInfoDto dto) {
        return courseInfoService.doUpdate(dto);
    }

}
