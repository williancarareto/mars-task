package com.marsrovers.browsers;

import com.marsrovers.models.Directions;

public interface Browser {

    int getX();
    int getY();

    Directions getDirections();

    void move();

    void rotateLeft();

    void rotateRight();

}
