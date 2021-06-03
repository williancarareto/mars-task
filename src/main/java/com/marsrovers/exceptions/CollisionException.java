package com.marsrovers.exceptions;

public class CollisionException extends RuntimeException {

    public CollisionException() {
    }

    public CollisionException(String message) {
        super(message);
    }
}
