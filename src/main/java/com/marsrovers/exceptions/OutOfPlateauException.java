package com.marsrovers.exceptions;

public class OutOfPlateauException extends RuntimeException {

    public OutOfPlateauException() {
    }

    public OutOfPlateauException(String message) {
        super(message);
    }
}
