package com.ssmdemo.service.impl;

import com.ssmdemo.dao.IUserDao;
import com.ssmdemo.model.User;
import com.ssmdemo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public List selectUserbByname(String username) {
        return this.userDao.selectUserByusername(username);
    }

}