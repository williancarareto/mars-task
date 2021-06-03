package com.marsrovers;

import com.marsrovers.exceptions.CollisionException;
import com.marsrovers.exceptions.InvalidCoordinatesException;
import com.marsrovers.exceptions.MovedOutOfPlateauException;
import com.marsrovers.exceptions.OutOfPlateauException;
import com.marsrovers.models.Directions;
import com.marsrovers.models.Rover;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test(expected = OutOfPlateauException.class)
    public void roverPosition_whenRoverIsOutOfPlateau_ThrowsException() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(5, 8, Directions.NORTH, "");

        plateau.registerRover(rover);
    }

    @Test
    public void roverPosition_whenRoverIsInsideThePlateau_RunsSuccessfully() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Directions.NORTH, "");

        plateau.registerRover(rover);
    }

    @Test
    public void browseRovers_whenItHasOneRover_browseThroughThePlateauAndReturnsTheFinalPosition() {
        int plateauX = 5;
        int plateauY = 5;
        int roverInitialX = 1;
        int roverInitialY = 2;

        Plateau plateau = new Plateau(plateauX, plateauY);
        Rover rover = new Rover(roverInitialX, roverInitialY, Directions.NORTH, "LMLMLMLMM");
        plateau.registerRover(rover);

        int expectedFinalRoverX = 1;
        int expectedFinalRoverY = 3;
        Directions expectedRoverDirection = Directions.NORTH;

        plateau.browseRovers();

        List<Rover> rovers = plateau.getRovers();
        Assert.assertEquals(expectedFinalRoverX, rovers.get(0).getX());
        Assert.assertEquals(expectedFinalRoverY, rovers.get(0).getY());
        Assert.assertEquals(expectedRoverDirection, rovers.get(0).getDirection());
    }

    @Test
    public void browseRovers_whenItHasTwoRovers_goThroughThePlateauAndReturnsTheLastPositions() {
        int plateauX = 5;
        int plateauY = 5;
        int rover1InitialX = 1;
        int rover1InitialY = 2;

        Plateau plateau = new Plateau(plateauX, plateauY);
        Rover rover1 = new Rover(rover1InitialX, rover1InitialY, Directions.NORTH, "LMLMLMLMM");
        plateau.registerRover(rover1);

        int rover2InitialX = 3;
        int rover2InitialY = 3;
        Rover rover2 = new Rover(rover2InitialX, rover2InitialY, Directions.EAST, "MMRMMRMRRM");
        plateau.registerRover(rover2);

        int expectedFinalRover1X = 1;
        int expectedFinalRover1Y = 3;
        Directions expectedRover1Direction = Directions.NORTH;

        int expectedFinalRover2X = 5;
        int expectedFinalRover2Y = 1;
        Directions expectedRover2Direction = Directions.EAST;

        plateau.browseRovers();

        List<Rover> rovers = plateau.getRovers();
        Assert.assertEquals(expectedFinalRover1X, rovers.get(0).getX());
        Assert.assertEquals(expectedFinalRover1Y, rovers.get(0).getY());
        Assert.assertEquals(expectedRover1Direction, rovers.get(0).getDirection());
        Assert.assertEquals(expectedFinalRover2X, rovers.get(1).getX());
        Assert.assertEquals(expectedFinalRover2Y, rovers.get(1).getY());
        Assert.assertEquals(expectedRover2Direction, rovers.get(1).getDirection());
    }

    @Test(expected = CollisionException.class)
    public void browseRovers_whenRegisterTwoRoversInTheSamePosition_ThrowsException(){
        int plateauX = 5;
        int plateauY = 5;
        int rover1InitialX = 1;
        int rover1InitialY = 2;

        Plateau plateau = new Plateau(plateauX, plateauY);
        Rover rover1 = new Rover(rover1InitialX, rover1InitialY, Directions.NORTH, "M");
        plateau.registerRover(rover1);

        int rover2InitialX = 1;
        int rover2InitialY = 2;
        Rover rover2 = new Rover(rover2InitialX, rover2InitialY, Directions.EAST, "MMRMMRMRRM");
        plateau.registerRover(rover2);

        plateau.browseRovers();
    }

    @Test(expected = CollisionException.class)
    public void browseRovers_whenItHasTwoRoversWithCollision_ThrowsException() {
        int plateauX = 5;
        int plateauY = 5;
        int rover1InitialX = 1;
        int rover1InitialY = 2;

        Plateau plateau = new Plateau(plateauX, plateauY);
        Rover rover1 = new Rover(rover1InitialX, rover1InitialY, Directions.NORTH, "M");
        plateau.registerRover(rover1);

        int rover2InitialX = 1;
        int rover2InitialY = 3;
        Rover rover2 = new Rover(rover2InitialX, rover2InitialY, Directions.EAST, "MMRMMRMRRM");
        plateau.registerRover(rover2);

        plateau.browseRovers();
    }

    @Test(expected = MovedOutOfPlateauException.class)
    public void browseRovers_whenMoveToOutThePlateau_ThrowsException() {
        int plateauX = 5;
        int plateauY = 5;
        int roverInitialX = 1;
        int roverInitialY = 2;

        Plateau plateau = new Plateau(plateauX, plateauY);
        Rover rover = new Rover(roverInitialX, roverInitialY, Directions.WEST, "MM");
        plateau.registerRover(rover);

        plateau.browseRovers();
    }
}
