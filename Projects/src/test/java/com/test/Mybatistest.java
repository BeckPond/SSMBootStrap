package com.test;

import com.test.dao.IuserDao;
import com.test.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatistest {
    public static void main(String[] args) throws IOException {
        //1读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建一个gongchang
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3 使用工厂创建对象
        SqlSession Session = sqlSessionFactory.openSession();
        //4创建Dao接口的代理对象
        IuserDao userDao = Session.getMapper(IuserDao.class );
        //5 代理对象执行方法
        List<User> users = userDao.findAlll();
        for (User user: users
             ) {
            System.out.println(user);
        }
        //6释放资源
        Session.close();
        is.close();
    }
}
