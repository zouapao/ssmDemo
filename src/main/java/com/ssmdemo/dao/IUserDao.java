package com.ssmdemo.dao;

import com.ssmdemo.model.User;

import java.util.List;

public interface IUserDao {

    User selectUser(long id);

    List<User> selectUserByusername(String username);

}