package org.example.logic;

import org.example.converter.ConvertId;
import org.example.nomalException.InputException;

import java.util.Scanner;

public class Route {
    private String routeCode;
    private int distance;
    private int numberOfStops;
    public Route(String code, Integer distance, Integer numberOfStops) {
        this.routeCode = code;
        this.distance = distance;
        this.numberOfStops = numberOfStops;
    }
    public static Route inputRoute(Scanner scanner){
        System.out.println("\nEnter 3 line to add a new route.");
        String code = null;
        while (true){
            System.out.print("Route code(Enter 3 characters): ");
            String c = scanner.nextLine();
            if(c.length() == 3){
                code = c;
                break;
            }
            else{
                System.out.println("Please enter 3 characters.");
            }
        }
        int distance = InputException.numberInputException(scanner, "Distance(km): ");
        int numberOfStops = InputException.numberInputException(scanner, "Number of stops: ");
        return new Route(code, distance,numberOfStops);
    }

    @Override
    public String toString() {
        return "Route code: " + routeCode +
                "\n\tDistance: " + distance +"(km)" +
                "\n\tNumber of stops: " + numberOfStops + "\n";
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }
}