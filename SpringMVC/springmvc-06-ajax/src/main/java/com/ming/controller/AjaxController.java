package com.ming.controller;

import com.ming.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController //不需要请求页面
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>" + name);
        if ("kuangshen".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }
    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();

        // 添加数据
        userList.add(new User("狂神说Java",2,"男"));
        userList.add(new User("狂神说前端",3,"女"));
        userList.add(new User("狂神说说运维",1,"男"));

        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg = "";
        if(name != null){
            // admin 这些数据库在数据库
            if ("admin".equals(name)){
                msg = "ok";
            }else {
                msg = "用户名有错";
            }
        }
        if(pwd != null){
            // admin 这些数据库在数据库
            if ("123456".equals(pwd)){
                msg = "ok";
            }else {
                msg = "密码输入有错";
            }
        }
        return msg;
    }


}
