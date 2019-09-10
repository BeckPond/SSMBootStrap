import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    String resource;
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void init() throws IOException {
        resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @After
    public void destroy(){
        session.commit();
        session.close();
    }

    @Test
    public void listCategory(){
        List<Category> cs =session.selectList("listCategory");
        for (Category c: cs
             ) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p:ps
                 ) {
                System.out.println("\t" +p);
            }
        }
    }
}
