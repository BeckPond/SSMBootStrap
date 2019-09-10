package com.trial.Dao;

import com.trial.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有
    List<User> findAll();

    //保存
    void saveUser(User user);
}