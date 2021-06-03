package com.marsrovers;

import com.marsrovers.browsers.Browser;
import com.marsrovers.browsers.Rover;
import com.marsrovers.exceptions.CollisionException;
import com.marsrovers.exceptions.MovedOutOfPlateauException;
import com.marsrovers.exceptions.OutOfPlateauException;
import com.marsrovers.models.Actions;
import com.marsrovers.models.Directions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProcessorTest {

    @Test(expected = OutOfPlateauException.class)
    public void browserPosition_whenBrowserIsOutOfPlateau_ThrowsException() {
        Processor processor = new Processor(new Plateau(5, 5));
        Browser browser = new Rover(5, 8, Directions.NORTH);

        processor.registerBrowser(browser, new ArrayList<>());
    }

    @Test
    public void browserPosition_whenBrowserIsInsideThePlateau_RunsSuccessfully() {
        Processor processor = new Processor(new Plateau(5, 5));
        Browser browser = new Rover(1, 2, Directions.NORTH);

        processor.registerBrowser(browser, new ArrayList<>());
    }

    @Test
    public void browsePlateau_whenItHasOneBrowser_browseThroughThePlateauAndReturnsTheFinalPosition() {
        int plateauX = 5;
        int plateauY = 5;

        int browserInitialX = 1;
        int browserInitialY = 2;

        Processor processor = new Processor(new Plateau(plateauX, plateauY));
        Browser browser = new Rover(browserInitialX, browserInitialY, Directions.NORTH);
        processor.registerBrowser(browser, Actions.convertToList("LMLMLMLMM"));

        int expectedFinalX = 1;
        int expectedFinalY = 3;
        Directions expectedFinalDirection = Directions.NORTH;

        processor.browsePlateau();

        List<Browser> browsers = processor.getBrowsers();
        Assert.assertEquals(expectedFinalX, browsers.get(0).getX());
        Assert.assertEquals(expectedFinalY, browsers.get(0).getY());
        Assert.assertEquals(expectedFinalDirection, browsers.get(0).getDirection());
    }

    @Test
    public void browsePlateau_whenItHasTwoBrowser_goThroughThePlateauAndReturnsTheLastPositions() {
        int plateauX = 5;
        int plateauY = 5;

        int browser1InitialX = 1;
        int browser1InitialY = 2;
        String actions1 = "LMLMLMLMM";

        Processor processor = new Processor(new Plateau(plateauX, plateauY));
        Browser browser1 = new Rover(browser1InitialX, browser1InitialY, Directions.NORTH);
        processor.registerBrowser(browser1, Actions.convertToList(actions1));

        int browser2InitialX = 3;
        int browser2InitialY = 3;
        String actions2 = "MMRMMRMRRM";
        Browser browser2 = new Rover(browser2InitialX, browser2InitialY, Directions.EAST);
        processor.registerBrowser(browser2, Actions.convertToList(actions2));

        int expectedFinalBrowser1X = 1;
        int expectedFinalBrowser1Y = 3;
        Directions expectedBrowser1Direction = Directions.NORTH;

        int expectedFinalBrowser2X = 5;
        int expectedFinalBrowser2Y = 1;
        Directions expectedBrowser2Direction = Directions.EAST;

        processor.browsePlateau();

        List<Browser> browsers = processor.getBrowsers();
        Assert.assertEquals(expectedFinalBrowser1X, browsers.get(0).getX());
        Assert.assertEquals(expectedFinalBrowser1Y, browsers.get(0).getY());
        Assert.assertEquals(expectedBrowser1Direction, browsers.get(0).getDirection());
        Assert.assertEquals(expectedFinalBrowser2X, browsers.get(1).getX());
        Assert.assertEquals(expectedFinalBrowser2Y, browsers.get(1).getY());
        Assert.assertEquals(expectedBrowser2Direction, browsers.get(1).getDirection());
    }

    @Test(expected = CollisionException.class)
    public void browsePlateau_whenRegisterTwoBrowsersInTheSamePosition_ThrowsException() {
        int plateauX = 5;
        int plateauY = 5;

        int browser1InitialX = 1;
        int browser1InitialY = 2;

        Processor processor = new Processor( new Plateau(plateauX, plateauY));
        Rover browser1 = new Rover(browser1InitialX, browser1InitialY, Directions.NORTH);
        processor.registerBrowser(browser1, Actions.convertToList("M"));

        int browser2InitialX = 1;
        int browser2InitialY = 2;
        Browser browser2 = new Rover(browser2InitialX, browser2InitialY, Directions.EAST);
        processor.registerBrowser(browser2, Actions.convertToList("MMRMMRMRRM"));

        processor.browsePlateau();
    }

    @Test(expected = CollisionException.class)
    public void browsePlateau_whenItHasTwoBrowsersWithCollision_ThrowsException() {
        int plateauX = 5;
        int plateauY = 5;

        int browser1InitialX = 1;
        int browser1InitialY = 2;

        Processor processor = new Processor(new Plateau(plateauX, plateauY));
        Rover browser1 = new Rover(browser1InitialX, browser1InitialY, Directions.NORTH);
        processor.registerBrowser(browser1, Actions.convertToList("M"));

        int browser2InitialX = 1;
        int browser2InitialY = 3;
        Browser browser2 = new Rover(browser2InitialX, browser2InitialY, Directions.EAST);
        processor.registerBrowser(browser2, Actions.convertToList("MMRMMRMRRM"));

        processor.browsePlateau();
    }

    @Test(expected = MovedOutOfPlateauException.class)
    public void browseRovers_whenMoveToOutThePlateau_ThrowsException() {
        int plateauX = 5;
        int plateauY = 5;
        int browserInitialX = 1;
        int browserInitialY = 2;

        Processor processor = new Processor(new Plateau(plateauX, plateauY));
        Rover rover = new Rover(browserInitialX, browserInitialY, Directions.WEST);
        processor.registerBrowser(rover, Actions.convertToList("MM"));

        processor.browsePlateau();
    }
}