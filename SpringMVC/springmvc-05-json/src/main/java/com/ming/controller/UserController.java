package com.ming.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ming.pojo.User;
import com.ming.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*@Controller 走视图解析器*/
@RestController // 下面所有方法不走视图解析器
public class UserController {

    @RequestMapping(value = "/json1")
//    @ResponseBody // 不会走视图解析器ViewResolver，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 创建一个对象
        User user = new User("李好帅", 3, "男");

        String s = mapper.writeValueAsString(user);

        return s;
    }

    @RequestMapping(value = "/json2")
    public String json2() throws JsonProcessingException {

        List<User> list = new ArrayList<User>();

        // 创建一个对象
        User user1 = new User("李好帅1", 3, "男");
        User user2 = new User("李好帅2", 3, "男");
        User user3 = new User("李好帅3", 3, "男");
        User user4 = new User("李好帅4", 3, "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        String s =  new ObjectMapper().writeValueAsString(list);

        return s;
    }


    @RequestMapping(value = "/json3")
    public String json3(){

        Date date = new Date();

        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping(value = "/json4")
    public String json4() throws JsonProcessingException {

        List<User> list = new ArrayList<User>();

        // 创建一个对象
        User user1 = new User("李好帅1", 3, "男");
        User user2 = new User("李好帅2", 3, "男");
        User user3 = new User("李好帅3", 3, "男");
        User user4 = new User("李好帅4", 3, "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return JsonUtils.getJson(list);
    }


    @RequestMapping(value = "/json5")
    public String json5() throws JsonProcessingException {

        List<User> list = new ArrayList<User>();

        // 创建一个对象
        User user1 = new User("李好帅1", 3, "男");
        User user2 = new User("李好帅2", 3, "男");
        User user3 = new User("李好帅3", 3, "男");
        User user4 = new User("李好帅4", 3, "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        String string = JSON.toJSONString(list);

        return string;
    }
}
