package com.ming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {

    @RequestMapping("m1/t1")
    public String test(Model model){

        model.addAttribute("msg","ModelTest1");
        // 转发URL 不变
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("m1/t2")
    public String test2(Model model){

        model.addAttribute("msg","ModelTest2");
        // 重定向 地址栏变化
        return "redirect:/index.jsp";
    }
}
