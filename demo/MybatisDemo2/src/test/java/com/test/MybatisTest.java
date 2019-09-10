package com.test;

import com.dao.IUserDao;
import com.domain.QueryVo;
import com.domain.User;
import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    InputStream is;
    SqlSession sqlSession;
    IUserDao userDao;
    @Before
    public void init() throws IOException{
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建一个SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //使用工厂生产一个SqlSession对象
        sqlSession = factory.openSession();
        //使用Sqlsession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }


    @Test
    public  void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user:users
             ) {
            System.out.println(user);

        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("masami");
        user.setAddress("japan jinggang");
        user.setBirthday(new Date());
        user.setSex("女");
        //使用代理对象执行方法
        userDao.saveUser(user);

//        //提交事务
//        sqlSession.commit();
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(50);
        user.setUsername("mnagasawa");
        user.setAddress("japan jinggang");
        user.setBirthday(new Date());
        user.setSex("女");
        //使用代理对象执行方法
        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        //使用代理对象执行方法
        userDao.deleteUser(48);
    }

    @Test
    public void testfindOne(){
        //使用代理对象执行方法
        User user = userDao.findbyId(50);
        System.out.println(user);
    }

    @Test
    public void testfindName(){
        //使用代理对象执行方法
        List<User> users =userDao.findbyName("%王%");
        for (User user:users
             ) {
            System.out.println(user);
        }
    }

    @Test
    public void testfindTotal(){
        //使用代理对象执行方法
        int count = userDao.findTotal();
        System.out.println(count);
    }

    @Test
    public void testfindVo(){
        //使用代理对象执行方法
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users =userDao.findUserByVo(vo);
        for (User u:users
        ) {
            System.out.println(u);
        }
    }
}
