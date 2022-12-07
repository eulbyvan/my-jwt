package com.enigmacamp.api.config;

import com.enigmacamp.api.interceptor.SimpleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 07/12/2022
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    SimpleInterceptor simpleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleInterceptor);
    }
}
