package com.marsrovers.exceptions;

public class InvalidCoordinatesException extends RuntimeException {

    public InvalidCoordinatesException() {
    }

    public InvalidCoordinatesException(String message) {
        super(message);
    }
}
