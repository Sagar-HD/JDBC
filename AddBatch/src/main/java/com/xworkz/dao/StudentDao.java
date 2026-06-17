package com.xworkz.dao;

import com.xworkz.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    void addStudents(List<StudentDto> students) throws ClassNotFoundException, SQLException;
}
