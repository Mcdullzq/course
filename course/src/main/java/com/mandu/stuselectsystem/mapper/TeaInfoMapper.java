package com.mandu.stuselectsystem.mapper;

import com.mandu.stuselectsystem.dto.CourseInfoDto;
import com.mandu.stuselectsystem.dto.TeaInfoDto;
import com.mandu.stuselectsystem.po.TeaInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeaInfoMapper {
    TeaInfo login(TeaInfoDto dto);

    int save(TeaInfoDto dto);

    List<TeaInfo> findByParam(TeaInfoDto dto);

    int delete(TeaInfoDto dto);

    int update(TeaInfoDto dto);

    List<TeaInfo> findByCourseId(CourseInfoDto dto);

    int updatePwd(TeaInfoDto dto);
}
