package com.ming.mapper;

import com.ming.pojo.User;
import com.ming.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    // 分页查询
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> list = mapper.getUserByLimit(map);
        for (User user : list) {
            System.out.println(user);

        }
        sqlSession.close();
    }

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //第一步，获得SqlSession对象

            logger.info("测试，进入getUserLike方法成功！");
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
    @Test
    public void testLog4j(){
        logger.info("info: 进入了testLog4j 方法");
        logger.debug("debug: 进入了testLog4j 方法");
        logger.error("error: 进入了testLog4j方法");
    }
}
