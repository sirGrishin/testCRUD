package com.example.testCRUD.exception;

import java.text.MessageFormat;

/**
 * @author Ilya Grishin
 */
public class BadRequestException extends ApplicationException {

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
