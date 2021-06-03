package com.marsrovers.exceptions;

public class MovedOutOfPlateauException extends RuntimeException {

    public MovedOutOfPlateauException() {
    }

    public MovedOutOfPlateauException(String message) {
        super(message);
    }
}
