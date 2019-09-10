package com.ssmtest.service;

import com.ssmtest.entity.PageBean;
import com.ssmtest.entity.User;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User loginByUserNameAndPassword(User record);

    List<User> selectUserList();

    int selectCount();

    int updateByPrimaryKeySelective(User record);

    PageBean<User> findByPage(int currentPage);
}