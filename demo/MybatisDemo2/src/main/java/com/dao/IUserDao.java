package com.dao;

import com.domain.QueryVo;
import com.domain.User;
import com.mysql.cj.Query;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User findbyId(Integer UserId);

    List<User> findbyName(String username);

    int findTotal();

    /*
    根据queryVo中的条件查询用户
     */
    List<User> findUserByVo(QueryVo Vo);

}
