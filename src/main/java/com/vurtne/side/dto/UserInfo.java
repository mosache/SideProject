package com.vurtne.side.dto;

import com.vurtne.side.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor(staticName = "from")
public class UserInfo {
    private String userNO;

    private String username;

    private Long createTime;

    public static UserInfo formUser(User user) {
        return UserInfo.from("",user.getUsername(),user.getCreate_time());
    }
}


