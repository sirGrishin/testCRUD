package com.example.testCRUD.exception;

/**
 * @author Ilya Grishin
 */

import java.text.MessageFormat;

/**
 * Базовый класс для исключительных ситуаций времени выполнения.
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}