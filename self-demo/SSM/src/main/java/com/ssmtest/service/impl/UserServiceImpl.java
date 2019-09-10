package com.ssmtest.service.impl;

import com.ssmtest.dao.UserDao;
import com.ssmtest.entity.PageBean;
import com.ssmtest.entity.User;
import com.ssmtest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;

    public int deleteByPrimaryKey(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }


    public int insertSelective(User record) {

        return userDao.insertSelective(record);
    }

    public User selectByPrimaryKey(Integer id) {

        return userDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    public List<User> selectUserList() {

        return userDao.selectUserList();
    }

    public int selectCount() {
        return userDao.selectCount();
    }

    public User loginByUserNameAndPassword(User record) {

        return userDao.loginByUserNameAndPassword(record);

    }

    public PageBean<User> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<User> pageBean = new PageBean<User>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=2;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = userDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<User> lists = userDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }
}