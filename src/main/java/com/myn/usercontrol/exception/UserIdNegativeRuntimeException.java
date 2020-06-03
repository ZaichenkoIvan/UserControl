package com.myn.usercontrol.exception;

public class UserIdNegativeRuntimeException extends RuntimeException {
    public UserIdNegativeRuntimeException() {
    }

    public UserIdNegativeRuntimeException(String message) {
        super(message);
    }

    public UserIdNegativeRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
