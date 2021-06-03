package com.marsrovers.models;

import com.marsrovers.exceptions.InvalidActionException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ActionsTest {

    @Test(expected = InvalidActionException.class)
    public void actions_whenLetterIsInvalid_ThrowsException(){
        String actions = "LMLLMT";
        Actions.convertToList(actions);
    }

    @Test
    public void actions_whenLetterIsValid_ReturnsTheAction(){
        String actions = "LMR";
        List<Actions> actionsList = Actions.convertToList(actions);

        Assert.assertEquals(Actions.LEFT, actionsList.get(0));
        Assert.assertEquals(Actions.MOVE, actionsList.get(1));
        Assert.assertEquals(Actions.RIGHT, actionsList.get(2));
    }
}
