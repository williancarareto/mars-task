package com.marsrovers;

import com.marsrovers.models.Directions;
import com.marsrovers.models.Rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Plateau plateau = createsPlateau();
        List<Rover> rovers = createsRovers();
        for (Rover rover: rovers) {
            plateau.registerRover(rover);
        }

        plateau.browseRovers();
        printOutput(plateau);
    }

    private static Plateau createsPlateau() {
        System.out.println("Insert the plateau/grid size: ");
        String plateauSize = scanner.nextLine();

        String[] plateauSizes = plateauSize.split(" ");
        int plateauX = Integer.parseInt(plateauSizes[0]);
        int plateauY = Integer.parseInt(plateauSizes[1]);

        return new Plateau(plateauX, plateauY);
    }

    private static List<Rover> createsRovers(){
        List<Rover> roversList = new ArrayList<>();
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
            Rover rover = new Rover(roverX, roverY, roverDirection, roverActions);
            roversList.add(rover);
        }

        return roversList;
    }

    private static void printOutput(Plateau plateau){
        System.out.println("\n\nOutput: ");
        List<Rover> roverOutput = plateau.getRovers();
        for (Rover rover: roverOutput) {
            System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirection().getDirection());
        }
    }
}
