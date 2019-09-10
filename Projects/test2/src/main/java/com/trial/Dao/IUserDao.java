package com.trial.Dao;

import com.trial.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}