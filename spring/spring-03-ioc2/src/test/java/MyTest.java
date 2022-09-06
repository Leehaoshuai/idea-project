import com.ming.pojo.User;
import com.ming.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
//        User user = new User();
        // spring 类似于婚介网站
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = (User) context.getBean("user2");
        UserT userT2 = (UserT) context.getBean("T2");
        userT2.show();
        user.show();
    }
}
