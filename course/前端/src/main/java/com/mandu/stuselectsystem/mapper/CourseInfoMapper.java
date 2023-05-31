package com.mandu.stuselectsystem.mapper;

import com.mandu.stuselectsystem.dto.CourseInfoDto;
import com.mandu.stuselectsystem.po.CourseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseInfoMapper {

    int save(CourseInfoDto dto);

    List<CourseInfo> findByParam(CourseInfoDto dto);

    int updateStatus(CourseInfoDto dto);

    int resetCourseStatus(int[] ids);

    int update(CourseInfoDto dto);


}
