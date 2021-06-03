package com.marsrovers.models;

import com.marsrovers.exceptions.InvalidDirectionException;

public enum Directions {

    EAST('E') {
        public Directions getLeft() {
            return null;
        }

        public Directions getRight() {
            return null;
        }
    }, WEST('W') {
        public Directions getLeft() {
            return null;
        }

        public Directions getRight() {
            return null;
        }
    }, SOUTH('S') {
        public Directions getLeft() {
            return null;
        }

        public Directions getRight() {
            return null;
        }
    }, NORTH('N') {
        public Directions getLeft() {
            return null;
        }

        public Directions getRight() {
            return null;
        }
    };

    private char direction;

    Directions(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public static Directions getDirection(char directionChar){
        Directions[] directions = Directions.values();

        for (Directions direction : directions){
            if (direction.direction == directionChar){
                return direction;
            }
        }

        throw new InvalidDirectionException("Invalid direction letter: " + directionChar);
    }

    public abstract Directions getLeft();
    public abstract Directions getRight();
}
