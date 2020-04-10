package com.fc.mapper;

import com.fc.model.SimpleStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<SimpleStudent> selectSimpleStudent(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    List<SimpleStudent> selectSimpleStudentByBelong(@Param("belong") Integer belong, @Param("start") Integer start, @Param("pageSize") Integer pageSize);
}
