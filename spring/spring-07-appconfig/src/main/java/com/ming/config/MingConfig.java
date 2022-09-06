package com.ming.config;

import com.ming.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration  // 这个也会注册到容器中，因为它本来就是一个@component, @Configuration 就和我们之前看到beans.xml一样
@ComponentScan("com.ming")
@Import(MingConfig2.class)
public class MingConfig {

    // 注册一个bean ， 就相当于一个bean标签，
    // 这个方法的名字 就相当于bean当中的id属性
    // 方法的返回值，就相当于 bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();
    }

}
