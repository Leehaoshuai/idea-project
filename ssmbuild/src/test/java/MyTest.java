import com.ming.pojo.Books;
import com.ming.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookService = context.getBean("BookServiceImpl", BookServiceImpl.class);
        for (Books books : bookService.queryAllBooks()) {
            System.out.println(books);
        }
    }
}
