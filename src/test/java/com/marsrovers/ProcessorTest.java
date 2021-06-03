package com.marsrovers;

import com.marsrovers.exceptions.CollisionException;
import com.marsrovers.exceptions.MovedOutOfPlateauException;
import com.marsrovers.exceptions.OutOfPlateauException;
import org.junit.Test;

public class ProcessorTest {

    @Test(expected = OutOfPlateauException.class)
    public void browserPosition_whenBrowserIsOutOfPlateau_ThrowsException(){

    }

    @Test
    public void browserPosition_whenBrowserIsInsideThePlateau_runnSuccessfully(){

    }

    @Test
    public void browserPlateau_whenItHasOneBrowser_browseThroughThePlateauAndReturnsTheFinalPosition(){

    }

    @Test
    public void browserPlateau_whenItHasTwoBrowser_goThroughThePlateauAndReturnsTheLastPosition(){

    }

    @Test(expected = CollisionException.class)
    public void browserPlateau_whenRegisterTwoBrowsersInTheSamePosition_ThrowsException(){

    }

    @Test(expected = CollisionException.class)
    public void browserPlateau_whenItHasTwoBrowserWithCollision_ThrowsException(){

    }

    @Test(expected = MovedOutOfPlateauException.class)
    public void browserRovers_whenMoveToOutOfThePlateau_ThrowsException(){

    }

}
