package com.mandu.stuselectsystem.mapper;

import com.mandu.stuselectsystem.dto.TeachCourseInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeachCourseInfoMapper {
     int save(TeachCourseInfoDto dto);

     List<Map<String,Object>> findByParam(TeachCourseInfoDto dto);

     int delete(TeachCourseInfoDto dto);
}
