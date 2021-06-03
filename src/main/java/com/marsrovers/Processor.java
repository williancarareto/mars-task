package com.marsrovers;

import com.marsrovers.browsers.Browser;
import com.marsrovers.exceptions.CollisionException;
import com.marsrovers.exceptions.MovedOutOfPlateauException;
import com.marsrovers.exceptions.OutOfPlateauException;
import com.marsrovers.models.Actions;

import java.util.List;

public class Processor {

    private Plateau plateau;

    public Processor(Plateau plateau) {
        this.plateau = plateau;
    }

    public void browsePlateau() {
        List<Browser> browsers = plateau.getBrowsers();
        List<List<Actions>> allActions = plateau.getActions();
        for (int i = 0; i < browsers.size(); i++) {
            Browser browser = browsers.get(i);
            List<Actions> actions = allActions.get(i);
            for (Actions action : actions) {
                switch (action) {
                    case LEFT:
                        browser.rotateLeft();
                        break;
                    case RIGHT:
                        browser.rotateRight();
                        break;
                    case MOVE:
                        browser.move();
                        checkLocation(browser);
                        checkCollision(browser);
                        break;
                }
            }
        }
    }

    public void registerBrowser(Browser browser, List<Actions> actions) {
        if (!isRoverInsidePlateauLimits(browser)) {
            throw new OutOfPlateauException("Rover is out of the plateau limits. Plateau limits x,y: "
                    + plateau.getX() + ", " + plateau.getY() + ". Rover x, y: " + plateau.getX() + ", " + plateau.getY());
        }

        checkCollision(browser);
        plateau.addBrowser(browser, actions);
    }

    public void printBrowsersPositions() {
        System.out.println("\n\nOutput: ");
        List<Browser> browsers = plateau.getBrowsers();
        for (Browser browser : browsers) {
            System.out.println(browser.getX() + " " + browser.getY() + " " + browser.getDirection());
        }
    }

    public List<Browser> getBrowsers() {
        return plateau.getBrowsers();
    }

    private boolean isRoverInsidePlateauLimits(Browser browser) {
        return browser.getX() <= plateau.getX() && browser.getY() <= plateau.getY();
    }

    private void checkLocation(Browser currentBrowser) {
        if (currentBrowser.getX() < 0 || currentBrowser.getY() < 0 ||
                currentBrowser.getX() > plateau.getX() || currentBrowser.getY() > plateau.getY()){
            throw  new MovedOutOfPlateauException("Moved rover outside of plateau");
        }
    }

    private void checkCollision(Browser currentBrowser) {
        List<Browser> browsers = plateau.getBrowsers();
        for (Browser browser : browsers) {
            if (currentBrowser != browser) {
                if (browser.getX() == currentBrowser.getX() && browser.getY() == currentBrowser.getY()) {
                    throw new CollisionException("Collision between rovers in x,y: " + currentBrowser.getX() +
                            ", " + currentBrowser.getY());
                }
            }
        }
    }
}