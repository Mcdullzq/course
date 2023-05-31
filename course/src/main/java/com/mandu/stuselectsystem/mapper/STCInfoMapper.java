package com.mandu.stuselectsystem.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface STCInfoMapper {
    List<Map<String,Object>> findByParam(Map<String,String> map);

    int updateScore(Map<String,String> map);

    List<Map<String,Object>> findUnSelectedCourse(Map<String,String> map);

    int save(Map<String, String> map);

    List<Map<String,Object>> findSelectedCourse(Map<String,String> map);

    int delete(Map<String,String> map);
}
