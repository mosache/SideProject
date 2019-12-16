package com.vurtne.side.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vurtne.side.annotation.PassToken;
import com.vurtne.side.exception.TokenException;
import com.vurtne.side.mapper.UserMapper;
import com.vurtne.side.model.User;
import com.vurtne.side.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 判断是否有token，token是否合法
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private UserService UserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ///不是请求方法直接pass
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        ///有@passToke直接pass
        if (method.isAnnotationPresent(PassToken.class)) {
            return true;
        }

        ///获取token
        String token = request.getParameter("token");

        ///
        if (token == null) {
            throw new TokenException("token不存在！");
        }

        Long user_id = JWT.decode(token).getClaim("user_id").asLong();

        User user = UserService.getUserByID(user_id);

        if (user == null) {
            throw new TokenException("用户不存在！");
        }


        ///验证token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();

        try {
           verifier.verify(token);
        }catch (JWTVerificationException ex) {
            throw new TokenException("Token不合法！");
        }

        request.setAttribute("user_id",user.getId());

        return true;
    }
}
