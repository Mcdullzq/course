package com.mandu.stuselectsystem.mapper;

import com.mandu.stuselectsystem.dto.ClassroomInfoDto;
import com.mandu.stuselectsystem.po.ClassroomInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassroomMapper {
    int save(ClassroomInfoDto dto);
    List<ClassroomInfo> findByParam(ClassroomInfoDto dto);

    int updateStatus(ClassroomInfoDto dto);

    int update(ClassroomInfoDto dto);

    List<ClassroomInfo> findAllLocation();

    List<ClassroomInfo> findByLocation(ClassroomInfoDto dto);
}
