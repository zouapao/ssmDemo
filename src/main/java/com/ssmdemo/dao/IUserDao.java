package com.ssmdemo.dao;

import com.ssmdemo.model.User;

import java.util.List;

public interface IUserDao {

    User selectUser(long id);
	// add a remark
    List<User> selectUserByusername(String username);

}