package org.example.converter;

import org.example.model.AssignmentDTO;
import org.example.model.DriverDTO;
import org.example.model.RouteDTO;
import org.example.repository.entity.AssignmentEntity;
import org.example.repository.entity.DriverEntity;
import org.example.repository.entity.RouteEntity;

public class EntityConverter {
    public static DriverEntity toDriverEntity(DriverDTO driverDTO){
        DriverEntity driverEntity = new DriverEntity();
        driverEntity.setCode(driverDTO.getCode());
        driverEntity.setName(driverDTO.getName());
        driverEntity.setAddress(driverDTO.getAddress());
        driverEntity.setPhoneNumber(driverDTO.getPhoneNumber());
        driverEntity.setQualification(driverDTO.getQualification());

        return driverEntity;
    }
    public static RouteEntity toRouteEntity(RouteDTO routeDTO){
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setCode(routeDTO.getCode());
        routeEntity.setDistance(routeDTO.getDistance());
        routeEntity.setNumberOfStops(routeDTO.getNumberOfStops());

        return routeEntity;
    }
    public static AssignmentEntity toAssignmentEntity(AssignmentDTO assignmentDTO){
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        assignmentEntity.setId(assignmentDTO.getId());
//        assignmentEntity.setDriver_id(assignmentDTO.getDriver_id());
//        assignmentEntity.setRoute_id(assignmentDTO.getRoute_id());
        assignmentEntity.setRound(assignmentDTO.getRound());

        return assignmentEntity;
    }
}
