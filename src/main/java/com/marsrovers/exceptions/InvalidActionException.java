package com.marsrovers.exceptions;

public class InvalidActionException extends RuntimeException {

    public InvalidActionException() {
    }

    public InvalidActionException(String message) {
        super(message);
    }
}
