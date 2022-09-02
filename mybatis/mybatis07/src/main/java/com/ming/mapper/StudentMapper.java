package com.ming.mapper;

import com.ming.pojo.Student;

import java.util.List;

public interface StudentMapper {
    // 查询所有学生信息以及对应的老师信息
    List<Student> getStudent();

    List<Student> getStudent2();
}
