package com.marsrovers;

import com.marsrovers.browsers.Rover;
import com.marsrovers.models.Actions;
import com.marsrovers.models.Directions;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Plateau plateau = createsPlateau();
            Processor processor = new Processor(plateau);

            createsRovers(processor);

            processor.browsePlateau();
            processor.printBrowsersPositions();
        } catch (NumberFormatException ex) {
            System.err.println("Invalid Input, please provide the correct inputs");
        }
    }

    private static Plateau createsPlateau() {
        System.out.println("Insert the plateau/grid size: ");
        String plateauSize = scanner.nextLine();

        String[] plateauSizes = plateauSize.split(" ");
        int plateauX = Integer.parseInt(plateauSizes[0]);
        int plateauY = Integer.parseInt(plateauSizes[1]);

        return new Plateau(plateauX, plateauY);
    }

    private static void createsRovers(Processor processor) {
        System.out.println("How many rovers are there inside the plateau?");
        int roversCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roversCount; i++) {
            System.out.println("Insert rover's " + (i + 1) + " data:");
            String roverData = scanner.nextLine();

            String[] roverDataArray = roverData.split(" ");
            int roverX = Integer.parseInt(roverDataArray[0]);
            int roverY = Integer.parseInt(roverDataArray[1]);
            Directions roverDirection = Directions.getDirection(roverDataArray[2].toUpperCase().charAt(0));

            System.out.println("Insert rover's " + (i + 1) + " actions:");
            String roverActions = scanner.nextLine();
            Rover rover = new Rover(roverX, roverY, roverDirection);
            processor.registerBrowser(rover, Actions.convertToList(roverActions));
        }
    }
}