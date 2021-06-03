package com.marsrovers;

import com.marsrovers.browsers.Browser;
import com.marsrovers.exceptions.CollisionException;
import com.marsrovers.exceptions.InvalidCoordinatesException;
import com.marsrovers.exceptions.MovedOutOfPlateauException;
import com.marsrovers.exceptions.OutOfPlateauException;
import com.marsrovers.models.Actions;
import com.marsrovers.models.Directions;
import com.marsrovers.models.Rover;

import javax.sql.rowset.BaseRowSet;
import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private int x;
    private int y;
    private List<Browser> browsers;
    private List<List<Actions>> actions;


    public Plateau(int x, int y) {
        if (!isCoordinatesValid(x, y)) {
            throw new InvalidCoordinatesException("Invalid position creating plateau on x: " + x + " and y: " + y);
        }

        this.x = x;
        this.y = y;
        this.browsers = new ArrayList<>();
        this.actions = new ArrayList<>();
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void addBrowser(Browser browser, List<Actions> actionsList){
        browsers.add(browser);
        actions.add(actionsList);
    }

    public List<Browser> getBrowsers(){
        return browsers;
    }

    public List<List<Actions>> getActions() {
        return actions;
    }

    private boolean isCoordinatesValid(int x, int y){
        return x > 0 && y > 0;
    }
}
