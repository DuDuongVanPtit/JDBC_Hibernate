package org.example.repository;

import org.example.repository.entity.DriverEntity;

import java.util.List;

public interface DriverRepository {
    void addDriver(DriverEntity driverEntity);
    List<DriverEntity> getAllDriver();

}
