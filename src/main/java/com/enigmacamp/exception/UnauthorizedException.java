package com.enigmacamp.exception;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 07/12/2022
 */

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("unauthorized token");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
