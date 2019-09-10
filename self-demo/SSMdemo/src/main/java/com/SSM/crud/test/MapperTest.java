package com.SSM.crud.test;


import com.SSM.crud.bean.Department;
import com.SSM.crud.bean.Employee;
import com.SSM.crud.dao.DepartmentMapper;
import com.SSM.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**可以使用Spring单元测试，要导入SpringTest
 * @ContextConfiguration 指定配置文件的位置
 * 直接AutoWired
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    //测试DepartmentMapper
    @Test
    public void testCRUD(){
//        ApplicationContext ioc =new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentMapper departmentMapper=ioc.getBean(DepartmentMapper.class);
//        EmployeeMapper employeeMapper =ioc.getBean(EmployeeMapper.class);
//        System.out.println(departmentMapper);

        //1插入几个部门
//        departmentMapper.insertSelective(new Department(null,"开发部门"));
//        departmentMapper.insertSelective(new Department(null,"测试部门"));

        //2员工数据
//        employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@gmail.com",1));

        //3批量插入：使用可以执行批量操作的sqlsession
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i =0;i< 100;i++){
            String uid = UUID.randomUUID().toString().substring(0,5);
            employeeMapper.insertSelective(new Employee(null,uid,"M",uid+"@gmail.com",1));
        }
//        //4批量删除
//        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//        for (int i =0;i< 1000;i++){
//            employeeMapper.deleteByPrimaryKey(i);
//        }

    }
}
