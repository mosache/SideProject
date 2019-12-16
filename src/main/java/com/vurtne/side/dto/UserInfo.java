package com.vurtne.side.dto;

import com.vurtne.side.model.User;
import lombok.Data;

@Data
public class UserInfo {
    private String userNO;

    private String username;

    private Long createTime;

    private String token;

    public static UserInfo formUser(User user) {
        return new UserInfo(user.getId() + "",user.getUsername(),user.getCreate_time());
    }

    public UserInfo(String userNO, String username, Long createTime) {
        this.userNO = userNO;
        this.username = username;
        this.createTime = createTime;
    }
}


