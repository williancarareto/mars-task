package com.marsrovers;

import com.marsrovers.exceptions.InvalidCoordinatesException;
import org.junit.Test;

public class PlateauTest {

    @Test(expected = InvalidCoordinatesException.class)
    public void plateauSize_whenXIsNegative_throwsException() {
        int x = -1;
        int y = 5;

        new Plateau(x, y);
    }

    @Test(expected = InvalidCoordinatesException.class)
    public void plateauSize_whenYIsNegative_throwsException() {
        int x = 5;
        int y = -1;

        new Plateau(x, y);
    }

    @Test
    public void plateauSize_whenXAndYAreValid_createsPlateauSuccessfully() {
        int x = 5;
        int y = 5;

        new Plateau(x, y);
    }
}
