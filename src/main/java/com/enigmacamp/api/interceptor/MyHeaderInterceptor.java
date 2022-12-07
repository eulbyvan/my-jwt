package com.enigmacamp.api.interceptor;

import com.enigmacamp.exception.UnauthorizedException;
//import com.enigmacamp.util.JwtUtil;
import com.enigmacamp.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
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
    private RestClient restClient;

    @Value("${service.authentication}")
    String authServiceUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenHeader = request.getHeader("Authorization");
        String[] tokenBearer = tokenHeader.split(" ");
        restClient.get(authServiceUrl + "?token=" + tokenBearer[1]);
        return true;
    }
}
