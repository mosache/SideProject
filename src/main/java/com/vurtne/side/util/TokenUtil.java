package com.vurtne.side.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vurtne.side.model.User;


public class TokenUtil {
    /**
     * 根据用户获取token
     * */
    public static String getToken(User user) {
        String token = JWT.create().withClaim("user_id", user.getId()).
                sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
