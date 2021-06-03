package com.marsrovers.models;

import com.marsrovers.exceptions.InvalidActionException;

import java.util.ArrayList;
import java.util.List;

public enum Actions {
    MOVE('M'), LEFT('L'), RIGHT('R');

    private char action;

    Actions(char action) {
        this.action = action;
    }

    public char getAction() {
        return action;
    }

    public static List<Actions> convertToList(String actions) {
        List<Actions> actionsList = new ArrayList<>();

        for (int i = 0; i < actions.length(); i++) {
            Actions action = getActionFromChar(actions.charAt(i));
            actionsList.add(action);
        }

        return actionsList;
    }

    private static Actions getActionFromChar(char actionLetter) {
        Actions[] actions = Actions.values();

        for (Actions action : actions) {
            if (action.getAction() == actionLetter) {
                return action;
            }
        }

        throw new InvalidActionException("Invalid action letter: " + actionLetter);
    }
}
