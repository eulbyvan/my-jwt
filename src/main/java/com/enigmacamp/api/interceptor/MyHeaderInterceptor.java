package com.enigmacamp.api.interceptor;

import com.enigmacamp.exception.UnauthorizedException;
import com.enigmacamp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 07/12/2022
 */

@Component
public class MyHeaderInterceptor implements HandlerInterceptor {
//    @Autowired
//    JwtUtil jwtUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.authentication}")
    String authServiceUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenHeader = request.getHeader("Authorization");
        String[] tokenBearer = tokenHeader.split(" ");
        restTemplate.getForEntity(authServiceUrl + "?token=" + tokenBearer[1], String.class);
        return true;
    }
}
