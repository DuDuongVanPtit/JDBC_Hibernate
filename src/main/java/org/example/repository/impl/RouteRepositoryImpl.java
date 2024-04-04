package org.example.repository.impl;

import org.example.repository.RouteRepository;
import org.example.repository.entity.RouteEntity;
import org.example.utils.JDBCConnectorUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RouteRepositoryImpl implements RouteRepository {

    @Override
    public void addRoute(RouteEntity routeEntity) {
        String sql = "INSERT INTO route (code, distance, number_of_stops) VALUES (?, ?, ?)";
        executeQuery1(routeEntity, sql);
    }

    @Override
    public List<RouteEntity> getAllRoute() {
        StringBuilder sql = new StringBuilder("SELECT * FROM route r");
        return executeQuery2(sql.toString());
    }

    @Override
    public RouteEntity findRouteById(int id) {
        String sql = "SELECT * FROM route r WHERE id = " + id;
        return executeQuery3(sql);
    }

    public void executeQuery1(RouteEntity routeEntity, String sql){
        try {
            Connection connection = JDBCConnectorUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, routeEntity.getCode());
            pstmt.setInt(2, routeEntity.getDistance());
            pstmt.setInt(3, routeEntity.getNumberOfStops());
            pstmt.executeUpdate();
            System.out.println("ok");
        } catch (SQLException e) {
            System.err.println("Insert failed!");
            e.printStackTrace();
        }
    }
    public List<RouteEntity> executeQuery2(String sql){

        List<RouteEntity> result = new ArrayList<>();

        try(
                Connection connect = JDBCConnectorUtil.getConnection();
                Statement stm = connect.createStatement();
                ResultSet rs = stm.executeQuery(sql);)
        {
            while(rs.next()) {
                RouteEntity routeEntity = new RouteEntity();
                routeEntity.setId(rs.getInt("r.id"));
                routeEntity.setCode(rs.getString("r.code"));
                routeEntity.setDistance(rs.getInt("r.distance"));
                routeEntity.setNumberOfStops(rs.getInt("r.number_of_stops"));
                result.add(routeEntity);
            }
        }
        catch(SQLException e) {
            System.out.print("Failed");
            e.printStackTrace();
        }
        return result;
    }
    public RouteEntity executeQuery3(String sql){

        RouteEntity routeEntity = new RouteEntity();

        try(
                Connection connect = JDBCConnectorUtil.getConnection();
                Statement stm = connect.createStatement();
                ResultSet rs = stm.executeQuery(sql);)
        {
            while(rs.next()) {
                RouteEntity r = new RouteEntity();
                r.setId(rs.getInt("r.id"));
                r.setCode(rs.getString("r.code"));
                r.setDistance(rs.getInt("r.distance"));
                r.setNumberOfStops(rs.getInt("r.number_of_stops"));
                routeEntity = r;
            }
        }
        catch(SQLException e) {
            System.out.print("Failed");
            e.printStackTrace();
        }
        return routeEntity;
    }

}
