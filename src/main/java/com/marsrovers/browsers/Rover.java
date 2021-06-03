package com.marsrovers.browsers;

import com.marsrovers.exceptions.InvalidCoordinatesException;
import com.marsrovers.models.Directions;



public class Rover implements Browser {

    private int x;
    private int y;
    private Directions direction;

    public Rover(int x, int y, Directions direction) {
        if (!isCoordinatesValid(x, y)) {
            throw new InvalidCoordinatesException("Invalid position on x: " + x + " and y: " + y);
        }

        this.x = x;
        this.y = y;
        this.direction = direction;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Directions getDirection() {
        return direction;
    }

    @Override
    public void move(){

        switch (direction){
            case NORTH:
                y += 1;
                break;
            case WEST:
                x -= 1;
                break;
            case SOUTH:
                y -= 1;
                break;
            case EAST:
                x += 1;
                break;
        }
    }

    @Override
    public void rotateLeft(){
        direction = direction.getLeft();
    }

    @Override
    public void rotateRight() {
        direction = direction.getRight();

    }

    private boolean isCoordinatesValid(int x, int y) {
        return x > 0 && y > 0;
    }
}
