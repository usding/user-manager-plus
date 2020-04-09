package com.fc.mapper;

import com.fc.model.Students;
import com.fc.model.StudentsExample;
import org.springframework.stereotype.Repository;

/**
 * StudentsDAO继承基类
 */
@Repository
public interface StudentsDAO extends MyBatisBaseDao<Students, Integer, StudentsExample> {
}