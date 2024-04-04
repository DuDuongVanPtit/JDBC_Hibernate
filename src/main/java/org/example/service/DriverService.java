package org.example.service;

import org.example.model.DriverDTO;

import java.util.List;

public interface DriverService {
    void addDriver(DriverDTO driverDTO);
    List<DriverDTO> getAllDriver();
}
