package com.ming.mapper;

import com.ming.pojo.Blog;
import com.ming.pojo.User;
import com.ming.utils.IdUtils;
import com.ming.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        sqlSession.close();
//        mapper.updateUser(new User(2,"aaaa","bbbb"));

//        sqlSession.clearCache();
//        List<User> user2 = mapper.queryUserById(1);

        User user2 = mapper2.queryUserById(1);
        System.out.println("===================");
        System.out.println(user2);
        System.out.println(user == user2);

        sqlSession2.close();
    }
}
