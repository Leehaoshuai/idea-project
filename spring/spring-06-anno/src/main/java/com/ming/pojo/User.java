package com.ming.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价于 <bean id="user" class="com.ming.pojo.User"/>
// @Component 组件

@Component
//@Scope("singleton")
@Scope("prototype")
public class User {
    // 相当于 <property name="name" value="李灏"/>
//    @Value("李灏")
    public String name;

    @Value("李灏")
    public void setName(String name) {
        this.name = name;
    }
}
