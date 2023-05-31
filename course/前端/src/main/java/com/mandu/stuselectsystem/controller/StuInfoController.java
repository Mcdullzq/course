package com.mandu.stuselectsystem.controller;

import com.mandu.stuselectsystem.dto.StuInfoDto;
import com.mandu.stuselectsystem.service.StuInfoService;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/StuInfoController")
public class StuInfoController {
    @Resource
    private StuInfoService stuInfoService;

    @RequestMapping("/save")
    public ResultJson save(@RequestBody StuInfoDto dto){
        return stuInfoService.doSave(dto);
    }

    @RequestMapping("/findByParam")
    public ResultJson findByParam(@RequestBody StuInfoDto dto){
        return stuInfoService.findByParam(dto);
    }
    @RequestMapping("/delete")
    public ResultJson delete(@RequestBody StuInfoDto dto){
        return stuInfoService.delete(dto);
    }
    @RequestMapping("/update")
    public ResultJson update(@RequestBody StuInfoDto dto){
        return stuInfoService.update(dto);
    }

    @RequestMapping("/downLoad")
    public void downLoad(HttpServletResponse response) throws Exception {
        String fileName="上传学生信息的模板";
        response.setHeader("Content-Disposition", "attachment;filename="
                +URLEncoder.encode(fileName, "UTF-8")+".xls");
        org.springframework.core.io.Resource resource=
                new ClassPathResource("stu.xls");
        InputStream in=resource.getInputStream();
        OutputStream out=response.getOutputStream();
        IOUtils.copy(in, out);
        in.close();
        out.close();
    }
    @RequestMapping("/showFileContent")
    public ResultJson showFileContent(MultipartFile file) throws IOException {
        return stuInfoService.showFileContent(file);
    }
    @RequestMapping("/batchSave")
    public ResultJson batchSave(@RequestBody List<Map<String,String>> list)  {
        return stuInfoService.batchSave(list);
    }

    @RequestMapping("/Login")
    public ResultJson Login(@RequestBody StuInfoDto dto)  {
        return stuInfoService.Login(dto);
    }

    @RequestMapping("/updatePwd")
    public ResultJson updatePwd(@RequestBody StuInfoDto dto)  {
        return stuInfoService.updatePwd(dto);
    }

}
