package org.example.service.impl;

import org.example.converter.DTOConverter;
import org.example.converter.EntityConverter;
import org.example.model.RouteDTO;
import org.example.repository.RouteRepository;
import org.example.repository.entity.RouteEntity;
import org.example.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Override
    public void addRoute(RouteDTO routeDTO) {
        routeRepository.addRoute(EntityConverter.toRouteEntity(routeDTO));
    }

    @Override
    public List<RouteDTO> getAllRoute() {
        List<RouteDTO> routeDTOS = new ArrayList<>();
        List<RouteEntity> routeEntities = routeRepository.getAllRoute();
        for(RouteEntity r : routeEntities){
            routeDTOS.add(DTOConverter.routeEntityToRouteDTO(r));
        }

        return routeDTOS;
    }

    @Override
    public RouteDTO finByRouteId(int id) {
        RouteEntity routeEntity = routeRepository.findRouteById(id);
        return DTOConverter.routeEntityToRouteDTO(routeEntity);
    }
}
