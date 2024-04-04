package org.example.logic;

import org.example.model.DriverDTO;
import org.example.model.RouteDTO;

public class View {
    public static void menu(){
        System.out.println("==============MENU==============");
        System.out.println("Enter 1 to add a new driver list.\n" +
                "Enter 2 to add a new route list.\n" +
                "Enter 3 to create an assignment table.\n" +
                "Enter 4 to sort assignment table by driver name.\n" +
                "Enter 5 to sort assignment table by the number of route(decrease).\n" +
                "Enter 6 to create a daily driving distance long for each driver.\n" +
                "Enter 0 to finish.");
        System.out.println("------------------------");
    }
    public static void alert(int driverSize, int routeSize){
        if(driverSize == 0 && routeSize == 0){
            System.out.println("driver list and route list are empty, please add information for them.");
        }
        else if(driverSize == 0){
            System.out.println("driver list is empty, please add information for it.");
        }
        else if(routeSize == 0) System.out.println("route list is empty, please add information for it.");
    }
    public static void showDriver(DriverDTO driverDTO){
        System.out.println("Driver id: " + driverDTO.getId() +
                        "\n\tCode: " + driverDTO.getCode() +
                        "\n\tName: " + driverDTO.getName() +
                        "\n\tAddress: " + driverDTO.getAddress() +
                        "\n\tPhone Number: " + driverDTO.getPhoneNumber() +
                        "\n\tQualification: " + driverDTO.getQualification() +"\n");
    }
    public static void showRoute(RouteDTO routeDTO){
        System.out.println("Route id: " + routeDTO.getId() +
                        "\n\tCode: " + routeDTO.getCode() +
                        "\n\tDistance: " + routeDTO.getDistance() +"(km)" +
                        "\n\tNumber of stops: " + routeDTO.getNumberOfStops() + "\n");
    }
}
