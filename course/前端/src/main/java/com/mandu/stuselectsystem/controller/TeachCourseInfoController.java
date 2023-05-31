package com.mandu.stuselectsystem.controller;

import com.mandu.stuselectsystem.dto.TeachCourseInfoDto;
import com.mandu.stuselectsystem.service.TeachCourseInfoService;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/TeachCourseInfoController")
public class TeachCourseInfoController {
    @Resource
    private TeachCourseInfoService teachCourseInfoService;

    @RequestMapping("/save")
    public ResultJson save(@RequestBody TeachCourseInfoDto dto){
        return teachCourseInfoService.save(dto);
    }
    @RequestMapping("/findByParam")
    public ResultJson findByParam(@RequestBody TeachCourseInfoDto dto){
        return teachCourseInfoService.findByParam(dto);
    }

    @RequestMapping("/delete")
    public ResultJson delete(@RequestBody TeachCourseInfoDto dto){
        return teachCourseInfoService.doDelete(dto);
    }
}
