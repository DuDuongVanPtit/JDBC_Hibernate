package org.example.converter;

import org.example.logic.Driver;
import org.example.logic.Route;
import org.example.model.AssignmentDTO;
import org.example.model.DriverDTO;
import org.example.model.RouteDTO;
import org.example.repository.entity.AssignmentEntity;
import org.example.repository.entity.DriverEntity;
import org.example.repository.entity.RouteEntity;

public class DTOConverter {
    public static DriverDTO driverEntityToDriverDTO(DriverEntity driverEntity){
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(driverEntity.getId());
        driverDTO.setCode(driverEntity.getCode());
        driverDTO.setName(driverEntity.getName());
        driverDTO.setAddress(driverEntity.getAddress());
        driverDTO.setQualification(driverEntity.getQualification());
        driverDTO.setPhoneNumber(driverEntity.getPhoneNumber());

        return driverDTO;
    }
    public static DriverDTO driverToDriverDTO(Driver d){
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setCode(d.getDriverCode());
        driverDTO.setName(d.getDriverName());
        driverDTO.setAddress(d.getDriverAddress());
        driverDTO.setQualification(d.getDriverQualification());
        driverDTO.setPhoneNumber(d.getDriverPhoneNumber());

        return driverDTO;
    }
    public static RouteDTO routeEntityToRouteDTO(RouteEntity routeEntity){
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(routeEntity.getId());
        routeDTO.setCode(routeEntity.getCode());
        routeDTO.setDistance(routeEntity.getDistance());
        routeDTO.setNumberOfStops(routeEntity.getNumberOfStops());

        return routeDTO;
    }
    public static RouteDTO routeToRouteDTO(Route r){
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setCode(r.getRouteCode());
        routeDTO.setDistance(r.getDistance());
        routeDTO.setNumberOfStops(r.getNumberOfStops());

        return routeDTO;
    }

    public static AssignmentDTO assignmentEntityToAssignmentDTO(AssignmentEntity assignmentEntity){
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setId(assignmentEntity.getId());
        assignmentDTO.setDriver_id(assignmentEntity.getDriver().getId());
        assignmentDTO.setRoute_id(assignmentEntity.getRoute().getId());
        assignmentDTO.setRound(assignmentEntity.getRound());

        return assignmentDTO;
    }
}
