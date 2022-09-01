package com.ming.mapper;

import com.ming.pojo.User;
import com.ming.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //第一步，获得SqlSession对象

            // 方式一 执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);

            // 方式二：
//            List<User> userList = sqlSession.selectList("com.ming.dao.UserMapper.getUserList");
            System.out.println(user);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }
}
