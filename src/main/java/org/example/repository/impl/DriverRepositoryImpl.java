package org.example.repository.impl;

import org.example.repository.DriverRepository;
import org.example.repository.entity.DriverEntity;
import org.example.utils.JDBCConnectorUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepositoryImpl implements DriverRepository {
    @Override
    public void addDriver(DriverEntity driverEntity) {
        String sql = "INSERT INTO driver (code, name, address, phone_number, qualification) VALUES (?, ?, ?, ?, ?)";
        executeQuery1(driverEntity,sql);
    }
    public void executeQuery1(DriverEntity driverEntity, String sql){
        try {
            Connection connection = JDBCConnectorUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, driverEntity.getCode());
            pstmt.setString(2, driverEntity.getName());
            pstmt.setString(3, driverEntity.getAddress());
            pstmt.setString(4, driverEntity.getPhoneNumber());
            pstmt.setString(5, driverEntity.getQualification());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insert failed!");
            e.printStackTrace();
        }
    }

    @Override
    public List<DriverEntity> getAllDriver() {
        StringBuilder sql = new StringBuilder("SELECT * FROM driver d");
        return executeQuery2(sql.toString());
    }
    public List<DriverEntity> executeQuery2(String sql){

        List<DriverEntity> result = new ArrayList<>();

        try(
                Connection connect = JDBCConnectorUtil.getConnection();
                Statement stm = connect.createStatement();
                ResultSet rs = stm.executeQuery(sql);)
        {
            while(rs.next()) {
                DriverEntity driverEntity = new DriverEntity();
                driverEntity.setId(rs.getInt("d.id"));
                driverEntity.setCode(rs.getString("d.code"));
                driverEntity.setName(rs.getString("d.name"));
                driverEntity.setAddress(rs.getString("d.address"));
                driverEntity.setPhoneNumber(rs.getString("d.phone_number"));
                driverEntity.setQualification(rs.getString("d.qualification"));
                result.add(driverEntity);
            }
        }
        catch(SQLException e) {
            System.out.print("Failed");
            e.printStackTrace();
        }
        return result;
    }

}
