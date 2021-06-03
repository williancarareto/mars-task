package com.marsrovers.browsers;

import com.marsrovers.exceptions.InvalidCoordinatesException;
import com.marsrovers.models.Directions;
import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test(expected = InvalidCoordinatesException.class)
    public void roverSize_whenXisNegative_throwsException(){
        int x = -1;
        int y = 5;

        new Rover(x, y, Directions.NORTH);
    }

    @Test(expected = InvalidCoordinatesException.class)
    public void roverSize_whenYIsNegative_throwsException(){
        int x = 5;
        int y = -1;

        new Rover(x, y, Directions.NORTH);
    }

    @Test
    public void roverSize_whenXandYAreValid_shouldCreateRoverSuccessfully(){
        int x = 5;
        int y = 5;

        new Rover(x, y, Directions.NORTH);
    }

    @Test
    public void move_whenMoveNorth_shouldIncrementOneInY(){
        int initialY = 1;
        Browser browser = new Rover(1, initialY, Directions.NORTH);
        browser.move();

        Assert.assertEquals(initialY + 1, browser.getY());
    }

    @Test
    public void move_whenMoveSouth_ShouldDecrementOneInY(){
        int initialY = 1;
        Browser browser = new Rover(1, initialY, Directions.SOUTH);
        browser.move();

        Assert.assertEquals(initialY - 1, browser.getY());

    }

    @Test
    public void move_whenMoveEast_ShouldIncrementOneOnX(){
        int initialX = 1;
        Browser browser = new Rover(initialX, 1, Directions.EAST);
        browser.move();

        Assert.assertEquals(initialX + 1, browser.getX());
    }

    @Test
    public void move_whenMoveNorth_ShouldDecrementOneOnX(){
        int initialX = 1;
        Browser browser = new Rover(initialX, 1, Directions.WEST);
        browser.move();

        Assert.assertEquals(initialX - 1, browser.getX());
    }

}
