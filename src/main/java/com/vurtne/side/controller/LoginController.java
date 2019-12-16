package com.vurtne.side.controller;

import com.mysql.cj.util.StringUtils;
import com.vurtne.side.annotation.PassToken;
import com.vurtne.side.dto.UserInfo;
import com.vurtne.side.model.User;
import com.vurtne.side.model.VResponse;
import com.vurtne.side.service.UserService;
import com.vurtne.side.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Api(value = "User service")
public class LoginController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "LoginIn",notes = "登录",httpMethod = "POST")
    @ApiImplicitParam(dataType = "long",name = "id",value = "id",required = true)
    @PostMapping("/loginIn")
    @PassToken
    public VResponse<UserInfo> LoginIn(@RequestParam(value = "username",defaultValue = "") String username, @RequestParam(value = "password",defaultValue = "") String password) {
        User u = userService.LoginIn(username,password);
        if (u != null) {
            UserInfo ui = UserInfo.formUser(u);
            ui.setToken(TokenUtil.getToken(u));
            return VResponse.OK(ui);
        }else {
            VResponse.Error("用户不存在");
        }
        return null;
    }


}
