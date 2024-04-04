package org.example.repository;

import org.example.repository.entity.DriverEntity;
import org.example.repository.entity.RouteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RouteRepository {
    void addRoute(RouteEntity routeEntity);
    List<RouteEntity> getAllRoute();
    RouteEntity findRouteById(int id);
}
