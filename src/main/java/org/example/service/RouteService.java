package org.example.service;

import org.example.logic.Route;
import org.example.model.RouteDTO;

import java.util.List;

public interface RouteService {
    void addRoute(RouteDTO routeDTO);
    List<RouteDTO> getAllRoute();
    RouteDTO finByRouteId(int id);
}
