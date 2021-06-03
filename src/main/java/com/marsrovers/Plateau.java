package com.marsrovers;

import com.marsrovers.exceptions.CollisionException;
import com.marsrovers.exceptions.InvalidCoordinatesException;
import com.marsrovers.exceptions.MovedOutOfPlateauException;
import com.marsrovers.exceptions.OutOfPlateauException;
import com.marsrovers.models.Actions;
import com.marsrovers.models.Directions;
import com.marsrovers.models.Rover;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private int x;
    private int y;
    private List<Rover> rovers;

    public Plateau(int x, int y) {
        if (!isCoordinatesValid(x, y)) {
            throw new InvalidCoordinatesException("Invalid position creating plateau on x: " + x + " and y: " + y);
        }

        this.x = x;
        this.y = y;
        this.rovers = new ArrayList<>();
    }

    public void browseRovers() {
        for (Rover rover: rovers) {
            List<Actions> actions = rover.getActions();
            for (Actions action: actions) {
                switch (action){
                    case LEFT:
                        moveLeft(rover);
                        break;
                    case RIGHT:
                        moveRight(rover);
                        break;
                    case MOVE:
                        moveRover(rover);
                        break;
                }
            }
        }
    }

    public void registerRover(Rover rover) {
        if (!isRoverInsidePlateauLimits(rover)) {
            throw new OutOfPlateauException("Rover is out of the plateau limits. Plateau limits x,y: "
                    + x + ", " + y + ". Rover x, y: " + x + ", " + y);
        }

        checkCollision(rover);
        rovers.add(rover);
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    private boolean isCoordinatesValid(int x, int y) {
        return x > 0 && y > 0;
    }

    private boolean isRoverInsidePlateauLimits(Rover rover) {
        return rover.getX() <= x && rover.getY() <= y;
    }

    private void checkCollision(Rover currentRover){
        for (Rover rover: rovers) {
            if (currentRover != rover) {
                if (rover.getX() == currentRover.getX() && rover.getY() == currentRover.getY()) {
                    throw new CollisionException("Collision between rovers in x,y: " + x + ", " + y);
                }
            }
        }
    }

    private void moveLeft(Rover rover){
        if (rover.getDirection() == Directions.NORTH){
            rover.setDirection(Directions.WEST);
        } else if (rover.getDirection() == Directions.WEST){
            rover.setDirection(Directions.SOUTH);
        } else if (rover.getDirection() == Directions.SOUTH){
            rover.setDirection(Directions.EAST);
        } else if (rover.getDirection() == Directions.EAST){
            rover.setDirection(Directions.NORTH);
        }
    }

    private void moveRight(Rover rover) {
        if (rover.getDirection() == Directions.NORTH){
            rover.setDirection(Directions.EAST);
        } else if (rover.getDirection() == Directions.EAST){
            rover.setDirection(Directions.SOUTH);
        } else if (rover.getDirection() == Directions.SOUTH){
            rover.setDirection(Directions.WEST);
        } else if (rover.getDirection() == Directions.WEST){
            rover.setDirection(Directions.NORTH);
        }
    }

    private void moveRover(Rover rover){
        switch (rover.getDirection()){
            case NORTH:
                moveNorth(rover);
                break;
            case WEST:
                moveWest(rover);
                break;
            case SOUTH:
                moveSouth(rover);
                break;
            case EAST:
                moveEast(rover);
                break;
        }

        checkCollision(rover);
    }

    private void moveNorth(Rover rover){
        if (rover.getY() + 1 <= y){
            rover.setY(rover.getY() + 1);
        } else {
            throw  new MovedOutOfPlateauException("Moved rover outside of plateau");
        }
    }

    private void moveWest(Rover rover){
        if (rover.getX() - 1 >= 0){
            rover.setX(rover.getX() - 1);
        } else {
            throw  new MovedOutOfPlateauException("Moved rover outside of plateau");
        }
    }

    private void moveSouth(Rover rover){
        if (rover.getY() - 1 >= 0){
            rover.setY(rover.getY() - 1);
        } else {
            throw  new MovedOutOfPlateauException("Moved rover outside of plateau");
        }
    }

    private void moveEast(Rover rover){
        if (rover.getX() + 1 <= x){
            rover.setX(rover.getX() + 1);
        } else {
            throw  new MovedOutOfPlateauException("Moved rover outside of plateau");
        }
    }
}
