package com.ming.mapper;

import com.ming.pojo.User;
import com.ming.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {


    // 分页查询
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层使用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }
//        User user = mapper.getUserById(1);
//        System.out.println(user);
//        mapper.addUser(new User(6,"li","123455"));
//        mapper.updateUser(new User(6,"李","112223"));
        mapper.deleteUser(3);
        sqlSession.close();
    }


}
