package com.ming.mapper;

import com.ming.pojo.Blog;
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
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis1");
        blog.setAuthor("李");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis2");
        blog.setAuthor("李好");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis3");
        blog.setAuthor("李好帅");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis4");
        blog.setAuthor("李好帅66");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("views","9998");
//        map.put("title","Mybatis1");
        map.put("id","e0d0365bada743f0a1acddf28fdbccc2");
//        map.put("author","李");

        mapper.updateBlog(map);
//        for (Blog blog : blogs) {
//            System.out.println(blog);
//        }
        sqlSession.close();
    }

    @Test
    public void queryBlogForEach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);
        mapper.queryBlogForeach(map);

        sqlSession.close();
    }
}
