package com.ming.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class People {

/*    // 如果显示的定义了autowired的required属性为false，说明这个对象可以为null，否则不允许为空
    @Autowired(required = false)
    @Qualifier(value = "cat222")*/
    @Resource(name="cat222")
    private Cat cat;

    // Autowired 默认按照byType 同类型的bean大于1时按照byName Resource 先byName找不到 后byType
    // Autowired + Qualifier = Resource(java) 自动装配指定对象
    @Autowired
    @Qualifier(value = "dog222")
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public Dog getDog() {
        return dog;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
