    byName 会自动在容器上下文中和 (自己对象set方法) 后面的值对应的beanid 缺点：name 默认
    byType 会自动在容器上下文中和 (自己对象属性相同）的bean 
    Autowired 先通过byType 自动注入
## 注解说明
- @Autowired ： 自动装配通过类型再通过名字
- @Qualifier : 与Autowired 结合使用，指定对象名字
- @Nullable : 字段标记了这个注解 ，说明这个字段可以为null
- @Resource : java 自带的 Autowired + Qualifier = Resource(java) 自动装配指定对象
- @Component : 组件 ，放在类上，说明这个组件被bean管理了， 配合xml配置的组件扫描包使用
等价于 <bean id="user" class="com.ming.pojo.User"/>
衍生注解
@Controller
@Repository dao层
@Service
@Component
都代表将某个类注册到Spring中，装配Bean
- @Value: 相当于 <property name="name" value="李灏"/> setter 注入

- @Scope("singleton")
@Scope("prototype")
- 区别：
Autowired 默认按照byType 同类型的bean大于1时按照byName Resource 先byName找不到 后byType

## 常见配置beans.xml
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">
    <!--扫描指定的包，这个包下的注解就会生效-->
    <context:component-scan base-package="com.ming"/>

    <!--开启注解支持-->
    <context:annotation-config/>
</beans>
```


## JavaConfig实现配置
JavaConfig 
纯Java的配置方式
### 配置类的配置
- @Configuration  // 这个也会注册到容器中，因为它本来就是一个@component, @Configuration 就和我们之前看到beans.xml一样
- @ComponentScan("com.ming") 包扫描
- @Import(MingConfig2.class)

    // 注册一个bean ， 就相当于一个bean标签，
    // 这个方法的名字 就相当于bean当中的id属性
    // 方法的返回值，就相当于 bean标签中的class属性
    ```java
        @Bean
        public User getUser(){
            return new User();
        }

- 如果完全使用配置类方式去做，我们就只能通过 AnnotationConfigApplicationContext 
上下文来获取容器，通过配置类的class对象加载

## AOP
### 代理模式 
为什么要学习代理模式，？ 因为这就是面向切面编程的底层（SpringAOP 的底层） 【SpringAOP 和 SpringMVC】
代理模式分类

静态代理
```
抽象角色 ：一般会使用接口或者抽象类来解决
真实角色： 被代理的角色
代理角色： 代理真实角色， 代理真实角色后，我们一般会做一些附属操作
客户： 访问代理对象的人！
```
代理模式的好处，可以使真实的操作更加纯粹，不用去关注一些公共业务
公共业务交给代理角色！实现了业务的分工
公共业务发生拓展的时候，方便集中管理
缺点：
一个真实角色就会产生一个代理角色；代码量会翻倍~开发效率会变低


动态代理的好处
一个代理类可以代理多类，只要是实现了同一个接口即可

1.接口
2.真实角色
3.代理角色
4.客户端访问代理角色

动态代理 和静态代理角色一样
```java
package com.ming.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 等会我们会用这个类生成自动代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    // 生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(),this);
    }

    // 处理代理实例并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 动态代理的本质就是使用反射机制实现
        seeHouse();
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }

    public void seeHouse(){
        System.out.println("中介带看房子");
    }

    public void fare(){
        System.out.println("中介收中介费");
    }
}

```
```
动态代理 和静态代理角色一样
动态代理的代理类是动态生成的，不是我们直接写好的
动态代理分两大类： 基于接口的动态代理，基于类的动态代理
        基于接口的---JDK动态代理 【这里使用】
        基于类的：cglib
        java字节码实现： Javasist

需要了解两个类
Proxy：代理 InvocationHandler： 调用处理程序
```

AOP 通过动态代理实现

