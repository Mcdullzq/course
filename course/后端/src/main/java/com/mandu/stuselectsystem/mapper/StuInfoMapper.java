package com.mandu.stuselectsystem.mapper;

import com.mandu.stuselectsystem.dto.StuInfoDto;
import com.mandu.stuselectsystem.po.StuInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuInfoMapper {

    int save(StuInfoDto dto);

    List<StuInfo> findByParam(StuInfoDto dto);

    int delete(StuInfoDto dto);

    int edit(StuInfoDto dto);

    int batchSave(List<Map<String,String>> list);

    StuInfo Login(StuInfoDto dto);

    int updatePwd(StuInfoDto dto);

}
