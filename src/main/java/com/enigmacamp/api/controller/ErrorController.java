package com.enigmacamp.api.controller;

import com.enigmacamp.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 07/12/2022
 */

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(UnauthorizedException.class)
    ResponseEntity<String> handleUnauthorizedException(UnauthorizedException e) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("unauthorized");
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(UnauthorizedException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("unknown error");
    }
}
