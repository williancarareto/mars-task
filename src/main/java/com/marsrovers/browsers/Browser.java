package com.marsrovers.browsers;

import com.marsrovers.models.Directions;

public interface Browser {

    int getX();
    int getY();

    Directions getDirection();

    void move();

    void rotateLeft();

    void rotateRight();

}
