package com.ming.mapper;

import com.ming.pojo.Student;
import com.ming.pojo.Teacher;
import com.ming.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher1 = mapper.getTeacher2(1);
            System.out.println(teacher1);

        sqlSession.close();
    }
}
