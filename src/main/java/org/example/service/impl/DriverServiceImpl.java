package org.example.service.impl;

import org.example.converter.DTOConverter;
import org.example.converter.EntityConverter;
import org.example.logic.Driver;
import org.example.model.DriverDTO;
import org.example.repository.DriverRepository;
import org.example.repository.entity.DriverEntity;
import org.example.service.DriverService;
import org.example.utils.JDBCConnectorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;

    @Override
    public void addDriver(DriverDTO driverDTO) {
        driverRepository.addDriver(EntityConverter.toDriverEntity(driverDTO));
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        List<DriverEntity> driverEntities = driverRepository.getAllDriver();
        List<DriverDTO> driverDTOS = new ArrayList<>();
        for(DriverEntity driverEntity : driverEntities){
            driverDTOS.add(DTOConverter.driverEntityToDriverDTO(driverEntity));
        }
        return driverDTOS;
    }

}
