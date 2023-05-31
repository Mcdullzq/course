package com.mandu.stuselectsystem.controller;

import com.mandu.stuselectsystem.dto.CourseInfoDto;
import com.mandu.stuselectsystem.dto.TeaInfoDto;
import com.mandu.stuselectsystem.service.TeaInfoService;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/TeaInfoController")
public class TeaInfoController {
    @Resource
    private TeaInfoService teaInfoService;

    @RequestMapping("/login")
    public ResultJson login(@RequestBody TeaInfoDto dto){
        return teaInfoService.login(dto);
    }

    @RequestMapping("/save")
    public ResultJson save(@RequestBody TeaInfoDto dto){
        return teaInfoService.doSave(dto);
    }
    @RequestMapping("/findByParam")
    public ResultJson findByParam(@RequestBody TeaInfoDto dto){
        return teaInfoService.findByParam(dto);
    }
    @RequestMapping("/delete")
    public ResultJson delete(@RequestBody TeaInfoDto dto){
        return teaInfoService.doDelete(dto);
    }

    @RequestMapping("/edit")
    public ResultJson edit(@RequestBody TeaInfoDto dto){
        return teaInfoService.update(dto);
    }

    @RequestMapping("/findByCourseId")
    public ResultJson findByCourseId(@RequestBody CourseInfoDto dto){
        return teaInfoService.findByCourseId(dto);
    }

    @RequestMapping("/updatePwd")
    public ResultJson updatePwd(@RequestBody TeaInfoDto dto){
        return teaInfoService.updatePwd(dto);
    }

}
