import com.ming.pojo.Hello;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // create and configure beans 获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 我们的对象现在都在Spring中管理了，需要的时候取出来就行
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
