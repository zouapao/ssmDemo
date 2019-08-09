package com.ssmdemo.service;

import com.ssmdemo.model.User;

import java.util.List;

public interface IUserService {

    public User selectUser(long userId);

    public List<User> selectUserbByname(String username);
}