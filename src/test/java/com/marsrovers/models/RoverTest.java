package com.marsrovers.models;

import com.marsrovers.exceptions.InvalidCoordinatesException;
import org.junit.Test;

public class RoverTest {

    @Test(expected = InvalidCoordinatesException.class)
    public void roverSize_whenXIsNegative_throwsException(){
        int x = -1;
        int y = 5;

        new Rover(x, y, Directions.NORTH,"");
    }

    @Test(expected = InvalidCoordinatesException.class)
    public void roverSize_whenYIsNegative_throwsException(){
        int x = 5;
        int y = -1;

        new Rover(x, y, Directions.NORTH,"");
    }

    @Test
    public void roverSizer_whenXAndYAreValid_shouldCreateRoverSuccessfully(){
        int x = 5;
        int y = 5;

        new Rover(x, y, Directions.NORTH,"");
    }
}
