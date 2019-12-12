package com.vurtne.side.service;

import com.vurtne.side.mapper.UserMapper;
import com.vurtne.side.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUserByID(long id) {
        return userMapper.getUserByID(id);
    }
}
