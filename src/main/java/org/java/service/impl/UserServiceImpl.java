package org.java.service.impl;

import org.java.dao.UserMapper;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map getUser(String uname, String upwd) {

        return userMapper.getUser(uname, upwd);
    }
}
