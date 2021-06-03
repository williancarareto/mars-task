package com.marsrovers;

import com.marsrovers.browsers.Browser;
import com.marsrovers.models.Actions;

import java.util.List;

public class Processor {

    private Plateau plateau;

    public Processor(Plateau plateau) {
        this.plateau = plateau;
    }

    public void browsePlateau() {
    }

    public void registerBrowser(Browser browser, List<Actions> actions) {
        plateau.addBrowser(browser, actions);
    }

    public List<Browser> getBrowsers() {
        return plateau.getBrowsers();
    }
}