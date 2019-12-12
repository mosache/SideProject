package com.vurtne.side.controller;

import com.vurtne.side.dto.UserInfo;
import com.vurtne.side.model.User;
import com.vurtne.side.model.VResponse;
import com.vurtne.side.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("/loginIn")
    public VResponse<UserInfo> LoginIn(@RequestParam("id") long id) {
        User u = userService.getUserByID(id);
        return VResponse.OK(UserInfo.formUser(u));
    }
}
