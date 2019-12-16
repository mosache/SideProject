package com.vurtne.side.service;

import com.vurtne.side.exception.UserException;
import com.vurtne.side.mapper.UserMapper;
import com.vurtne.side.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Cacheable(value = "user_service",key = "targetClass + methodName + #p0")
    public User getUserByID(long id) {
        return userMapper.getUserByID(id);
    }

    public User LoginIn(String username, String password) {
        User user = userMapper.getUserByUserName(username);
        if (user == null) {
            throw new UserException();
        }

        if (!password.equals(user.getPassword())) {
            throw new UserException("密码错误");
        }
        return user;
    }
}
