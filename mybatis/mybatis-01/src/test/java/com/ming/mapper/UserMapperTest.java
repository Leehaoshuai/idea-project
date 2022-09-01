package com.ming.mapper;

import com.ming.pojo.User;
import com.ming.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%哈%");

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //第一步，获得SqlSession对象

            // 方式一 执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            // 方式二：
//            List<User> userList = sqlSession.selectList("com.ming.dao.UserMapper.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",3);
        map.put("name","张三");
        User user = mapper.getUserById2(map);
        System.out.println(user);

        sqlSession.close();
    }
    // 增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(5,"哈其","34567"));
        if (res > 0){
            System.out.println("插入成功！");
        }
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    // 修改需要提交事务
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.updateUser(new User(4,"不哈哈","34567"));
        if (res > 0){
            System.out.println("修改成功！");
        }
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    // 删除用户
    @Test
    public void deleteUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUserById(4);
        if (res > 0){
            System.out.println("删除成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    // 删除用户
    @Test
    public void deleteUserByIds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        int res = mapper.deleteUserByIds(list);
        if (res > 0){
            System.out.println("删除成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",5);
        map.put("userName","hello");
        map.put("password","23333");
        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }
}
