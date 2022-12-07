package com.enigmacamp.api.interceptor;

import com.enigmacamp.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre handle from " + request.getRequestURI());
        String token = request.getHeader("my-header");

        if (token == null) throw new UnauthorizedException();
        if (!token.equals("123")) throw new UnauthorizedException();

        return true;
    }
}
