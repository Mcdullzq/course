package com.mandu.stuselectsystem.service;

import com.mandu.stuselectsystem.dto.StuInfoDto;
import com.mandu.stuselectsystem.mapper.StuInfoMapper;
import com.mandu.stuselectsystem.po.StuInfo;
import com.mandu.stuselectsystem.util.ResultJson;
import jakarta.annotation.Resource;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuInfoService {
    @Resource
    private StuInfoMapper stuInfoMapper;

    public ResultJson doSave(StuInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = stuInfoMapper.save(dto);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }

    public ResultJson findByParam(StuInfoDto dto){
        ResultJson rst = new ResultJson();
        List<StuInfo> list = stuInfoMapper.findByParam(dto);
        rst.setData(list);
        return rst;
    }
    public ResultJson delete(StuInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = stuInfoMapper.delete(dto);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
    public ResultJson update(StuInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = stuInfoMapper.edit(dto);
        if(row ==0){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
    public ResultJson showFileContent(MultipartFile file) throws IOException {
        ResultJson rst=new ResultJson();
        HSSFWorkbook work=new HSSFWorkbook(file.getInputStream());
        HSSFSheet sheet=work.getSheetAt(0);
        int rows=sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> list=new ArrayList<>();
        for(int i=1;i<rows;i++) {
            HSSFRow row=sheet.getRow(i);
            String name=row.getCell(0).getStringCellValue();
            String sex=row.getCell(1).getStringCellValue();
            String email=row.getCell(2).getStringCellValue();
            Map<String, String> map=new HashMap<>();
            map.put("name", name);
            map.put("sex", sex);
            map.put("email", email);
            map.put("stuSex", "男".equals(sex)?"1":"2");
            list.add(map);
        }
        rst.setData(list);
        return rst;
    }

    public ResultJson batchSave(List<Map<String,String>> list){
        ResultJson rst = new ResultJson();
        int row = stuInfoMapper.batchSave(list);
        if(row == 0 ){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }

    public ResultJson Login(StuInfoDto dto){
        ResultJson rst = new ResultJson();
        StuInfo stu = stuInfoMapper.Login(dto);
        rst.setData(stu);
        return rst;
    }

    public ResultJson updatePwd(StuInfoDto dto){
        ResultJson rst = new ResultJson();
        int row = stuInfoMapper.updatePwd(dto);
        if(row == 0 ){
            rst.setCode(500);
            rst.setMsg("error");
        }
        return rst;
    }
}
