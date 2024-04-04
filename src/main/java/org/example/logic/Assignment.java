package org.example.logic;

import org.example.model.AssignmentDTO;
import org.example.model.DriverDTO;
import org.example.model.RouteDTO;
import org.example.nomalException.InputException;
import org.example.service.AssignmentService;
import org.example.service.RouteService;

import java.util.*;

public class Assignment {
    public static void assignmentTable(Scanner scanner, AssignmentService assignmentService, RouteService routeService, List<DriverDTO> driverDTOS1, List<RouteDTO> routeDTOS1){
        for(DriverDTO d : driverDTOS1){
            int driverId = d.getId();
            while(true){
                int rId = InputException.numberInputException(scanner, "Enter the route id you want to assign to driver " + d.getName() + "(enter 0 to finish): ");
                if(rId == 0) break;
                boolean checkAdd1 = false;
                for(RouteDTO r : routeDTOS1){
                    if(rId == r.getId()){
                        checkAdd1 = true;
                    }
                }
                if(checkAdd1){
                    boolean check = true;
                    List<AssignmentDTO> assignmentDTOS  = assignmentService.getAll();
                    for(AssignmentDTO a : assignmentDTOS){
                        if(driverId == a.getDriver_id() && rId == a.getRoute_id()){
                            System.out.println("Route " + a.getRoute_id() + " has been assigned to driver " + a.getDriver_id());
                            check = false;
                            break;
                        }

                    }
                    if(check){
                        int round = InputException.numberInputException(scanner, "Enter the number of round for route " + rId + ": ");
                        AssignmentDTO assignmentDTO = new AssignmentDTO();
                        assignmentDTO.setDriver_id(driverId);
                        assignmentDTO.setRoute_id(rId);
                        assignmentDTO.setRound(round);
                        assignmentService.addAssignment(assignmentDTO);
                    }
                }
                else System.out.println("The route id is not exist.");
            }
        }
        System.out.println("==============ASSIGNMENT TABLE==============\n");
        assignmentPerDriver(assignmentService,routeService, driverDTOS1, routeDTOS1);
    }
    public static void sortByDriverName(AssignmentService assignmentService, RouteService routeService, List<DriverDTO> driverDTOS, List<RouteDTO> routeDTOS){
        System.out.println("==============ASSIGNMENT TABLE SORTED BY DRIVER NAME==============");
        Collections.sort(driverDTOS, Comparator.comparing(DriverDTO::getName));
        assignmentPerDriver(assignmentService,routeService, driverDTOS, routeDTOS);
    }
    public static void sortByNumberOfRoute(AssignmentService assignmentService, RouteService routeService, List<DriverDTO> driverDTOS, List<RouteDTO> routeDTOS){
        System.out.println("==============ASSIGNMENT TABLE SORTED BY THE NUMBER OF ROUTE(DECREASE)==============");
        int cnt[] = new int[100000];
        List<AssignmentDTO> assignmentDTOS = assignmentService.getAll();
        for(AssignmentDTO a : assignmentDTOS){
            cnt[a.getDriver_id()]++;
        }
       Collections.sort(driverDTOS, (drivers1, driver2) -> Integer.compare(cnt[driver2.getId()], cnt[drivers1.getId()]));
        assignmentPerDriver(assignmentService,routeService, driverDTOS, routeDTOS);
    }
    public static void dailyDrivingDistanceLong(AssignmentService assignmentService, RouteService routeService, List<DriverDTO> driverDTOS, List<RouteDTO> routeDTOS){
        System.out.println("==============DAILY DRIVING DISTANCE LONG==============");
        for(DriverDTO d : driverDTOS){
            int totalDistanceLong = 0;
            List<AssignmentDTO> assignmentDTOS = assignmentService.getAll();
            for(AssignmentDTO a : assignmentDTOS){
                if(d.getId() == a.getDriver_id()){
                    RouteDTO r = routeService.finByRouteId(a.getRoute_id());
                    totalDistanceLong += (r.getDistance() * a.getRound());
                }
            }
            System.out.println("Driver " + d.getName() + ": " + totalDistanceLong + "(km)");
        }
    }
    public static void assignmentPerDriver(AssignmentService assignmentService, RouteService routeService, List<DriverDTO> driverDTOS1, List<RouteDTO> routeDTOS1){
        String result = "";
        for(DriverDTO d : driverDTOS1) {
            System.out.println("Driver " + d.getName() + ":");
            List<AssignmentDTO> assignmentDTOS = assignmentService.getAll();
            for (AssignmentDTO a : assignmentDTOS) {
                if (a.getDriver_id() == d.getId()) {
                    RouteDTO r = routeService.finByRouteId(a.getRoute_id());
                    System.out.println("\t+ Route id: " + r.getId() + " " + r.getDistance() + "(km)" + " " + a.getRound() + "(round)");
                }
            }
        }
    }
}
