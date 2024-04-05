package org.example;
import org.example.config.AppConfig;
import org.example.converter.DTOConverter;
import org.example.logic.Assignment;
import org.example.logic.Driver;
import org.example.logic.Route;
import org.example.logic.View;
import org.example.model.DriverDTO;
import org.example.model.RouteDTO;
import org.example.nomalException.InputException;
import org.example.service.AssignmentService;
import org.example.service.DriverService;
import org.example.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class Main {
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private RouteService routeService;
    public static ArrayList<Driver> drivers = new ArrayList<>();
    public static ArrayList<Route> routes = new ArrayList<>();
    public static void main(String[] args) {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            Main main = context.getBean(Main.class);
            main.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true){
                try {
                    View.menu();
                    int choice = scanner.nextInt();
                    if(choice == 0) break;
                    switch (choice){
                        case 1:
                            int n = InputException.numberInputException(scanner, "Enter the number of new driver: ");
                            for(int i = 0; i < n; i++){
                                driverService.addDriver(DTOConverter.driverToDriverDTO(Driver.inputDriver(scanner)));
                            }
                            System.out.println("\n==============DRIVER LIST==============\n");
                            List<DriverDTO> driverDTOS = driverService.getAllDriver();
                            for (DriverDTO driverDTO : driverDTOS){
                                View.showDriver(driverDTO);
                            }
                            break;
                        case 2:
                            int m = InputException.numberInputException(scanner, "Enter the number of new route: ");
                            for(int i = 0; i < m; i++){
                                routeService.addRoute(DTOConverter.routeToRouteDTO(Route.inputRoute(scanner)));
                            }
                            System.out.println("\n==============ROUTE LIST==============\n");
                            List<RouteDTO> routeDTOS = routeService.getAllRoute();
                            for(RouteDTO routeDTO : routeDTOS){
                                View.showRoute(routeDTO);
                            }
                            break;
                        case 3:
                            List<DriverDTO> driverDTOS1 = driverService.getAllDriver();
                            List<RouteDTO> routeDTOS1 = routeService.getAllRoute();
                            View.alert(driverDTOS1.size(), routeDTOS1.size());
                            if(driverDTOS1.size() > 0 && routeDTOS1.size() > 0){
                                Assignment.assignmentTable(scanner, assignmentService, routeService, driverDTOS1, routeDTOS1);
                            }
                            break;
                        case 4:
                            List<DriverDTO> driverDTOS2 = driverService.getAllDriver();
                            List<RouteDTO> routeDTOS2 = routeService.getAllRoute();
                            View.alert(driverDTOS2.size(), routeDTOS2.size());
                            if(driverDTOS2.size() > 0 && routeDTOS2.size() > 0){
                                Assignment.sortByDriverName(assignmentService, routeService, driverDTOS2, routeDTOS2);
                            }
                            break;
                        case 5:
                            List<DriverDTO> driverDTOS3 = driverService.getAllDriver();
                            List<RouteDTO> routeDTOS3 = routeService.getAllRoute();
                            View.alert(driverDTOS3.size(), routeDTOS3.size());
                            if(driverDTOS3.size() > 0 && routeDTOS3.size() > 0){
                                Assignment.sortByNumberOfRoute(assignmentService, routeService, driverDTOS3, routeDTOS3);
                            }
                            break;
                        case 6:
                            List<DriverDTO> driverDTOS4 = driverService.getAllDriver();
                            List<RouteDTO> routeDTOS4 = routeService.getAllRoute();
                            View.alert(driverDTOS4.size(), routeDTOS4.size());
                            if(driverDTOS4.size() > 0 && routeDTOS4.size() > 0){
                                Assignment.dailyDrivingDistanceLong(assignmentService, routeService, driverDTOS4, routeDTOS4);
                            }
                    }

                }
                catch (Exception e){
                    System.out.println(e);
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

