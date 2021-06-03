package com.marsrovers.models;

import com.marsrovers.exceptions.InvalidDirectionException;
import com.marsrovers.models.Directions;
import org.junit.Assert;
import org.junit.Test;

public class DirectionsTest {

    @Test(expected = InvalidDirectionException.class)
    public void directions_whenLetterIsInvalid_ThrowsException() {
        char directionChar = 'P';
        Directions.getDirection(directionChar);
    }

    @Test
    public void directions_whenLetterIsN_ReturnsNorth() {
        char directionChar = 'N';
        Directions expected = Directions.NORTH;

        Directions returnedDirection =  Directions.getDirection(directionChar);

        Assert.assertEquals(expected, returnedDirection);
    }

    @Test
    public void directions_whenLetterIsS_ReturnsSouth() {
        char directionChar = 'S';
        Directions expected = Directions.SOUTH;

        Directions returnedDirection =  Directions.getDirection(directionChar);

        Assert.assertEquals(expected, returnedDirection);
    }

    @Test
    public void directions_whenLetterIsE_ReturnsEast() {
        char directionChar = 'E';
        Directions expected = Directions.EAST;

        Directions returnedDirection =  Directions.getDirection(directionChar);

        Assert.assertEquals(expected, returnedDirection);
    }

    @Test
    public void directions_whenLetterIsW_ReturnsWest() {
        char directionChar = 'W';
        Directions expected = Directions.WEST;

        Directions returnedDirection =  Directions.getDirection(directionChar);

        Assert.assertEquals(expected, returnedDirection);
    }

    @Test
    public void directions_whenGetLeftFromNorth_ReturnsWest(){
        Directions left = Directions.NORTH.getLeft();
        Assert.assertEquals(Directions.WEST, left);

    }

    @Test
    public void directions_whenGetLeftFromWest_ReturnsSouth(){
        Directions left = Directions.WEST.getLeft();
        Assert.assertEquals(Directions.SOUTH, left);
    }

    @Test
    public void directions_whenGetLeftFromSouth_ReturnsEast(){
        Directions left = Directions.SOUTH.getLeft();
        Assert.assertEquals(Directions.EAST, left);

    }

    @Test
    public void directions_whenGetLeftFromEast_ReturnsNorth(){
        Directions left = Directions.EAST.getLeft();
        Assert.assertEquals(Directions.NORTH, left);

    }

    @Test
    public void directions_whenGetRightFromNorth_ReturnsEast(){
        Directions right = Directions.NORTH.getRight();
        Assert.assertEquals(Directions.EAST, right);

    }

    @Test
    public void directions_whenGetRightFromEast_ReturnsSouth(){
        Directions right = Directions.EAST.getRight();
        Assert.assertEquals(Directions.SOUTH, right);

    }

    @Test
    public void directions_whenGetRightFromSouth_ReturnsWest(){
        Directions right = Directions.SOUTH.getRight();
        Assert.assertEquals(Directions.WEST, right);

    }

    @Test
    public void directions_whenGetRightFromWest_ReturnsNorth() {
        Directions right = Directions.WEST.getRight();
        Assert.assertEquals(Directions.NORTH, right);
    }
}
