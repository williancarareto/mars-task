package com.marsrovers.exceptions;

public class InvalidDirectionException extends RuntimeException {

    public InvalidDirectionException() {
    }

    public InvalidDirectionException(String message) {
        super(message);
    }
}
