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
```
- 如果完全使用配置类方式去做，我们就只能通过 AnnotationConfigApplicationContext 
上下文来获取容器，通过配置类的class对象加载
