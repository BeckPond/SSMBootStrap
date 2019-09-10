package com.how2java.pojo;

import com.how2java.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    InputStream is ;
    SqlSessionFactory factory;
    SqlSession session;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession();
    }

    @After
    public void destroy(){
        session.commit();
        session.close();
    }

    @Test
    public void addCategory(){
        Category c = new Category();
        c.setName("新增加的Category");
        session.insert("addCategory",c);
    }

    @Test
    public void deleteCategory(){
        Category c=new Category();
        c.setId(11);
        session.delete("deleteCategory",c);
    }

    @Test
    public void updateCategory(){
        Category c = session.selectOne("updateCategory",3);
        c.setName("修改了的Category名");
        session.update("updateCategory");
    }

    @Test
    public void listAll() {
        List<Category> cs = session.selectList("listCategory");
        for (Category category: cs
        ) {
            System.out.println(category.getName());
        }
    }

    @Test
    public void getCategory(){
        Category c = session.selectOne("getCategory",2);
        System.out.println(c.getName());

    }

    @Test
    public void listbyName(){
        List<Category> cs = session.selectList("listCategoryByName","cat");
        for (Category c: cs
             ) {
            System.out.println(c);
        }
    }

    @Test
    public void listbyIdandName(){
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("id",3);
        params.put("name","cat");
        List<Category> cs = session.selectList("listCategoryByIdAndName",params);
        for (Category c:cs
             ) {
            System.out.println(c);
        }
    }
}
