package org.example.repository.impl;

import org.example.repository.AssignmentRepository;
import org.example.repository.entity.AssignmentEntity;
import org.example.utils.JDBCConnectorUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AssignmentRepositoryImpl implements AssignmentRepository {
    @Override
    public void addAssignment(AssignmentEntity assignmentEntity) {
        String sql = "INSERT INTO assignment (driver_id, route_id, round) VALUES (?, ?, ?)";
        executeQuery1(assignmentEntity, sql);
    }

    @Override
    public List<AssignmentEntity> getAll() {
        String sql = "SELECT * FROM assignment a";
        return executeQuery2(sql);
    }
    public void executeQuery1(AssignmentEntity assignmentEntity, String sql){
        try {
            Connection connection = JDBCConnectorUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, assignmentEntity.getDriver().getId());
            pstmt.setInt(2, assignmentEntity.getRoute().getId());
            pstmt.setInt(3, assignmentEntity.getRound());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insert failed!");
            e.printStackTrace();
        }
    }
    public List<AssignmentEntity> executeQuery2(String sql){
        List<AssignmentEntity> result = new ArrayList<>();

        try(
                Connection connect = JDBCConnectorUtil.getConnection();
                Statement stm = connect.createStatement();
                ResultSet rs = stm.executeQuery(sql);)
        {
            while(rs.next()) {
                AssignmentEntity assignmentEntity = new AssignmentEntity();
                assignmentEntity.setId(rs.getInt("a.id"));
//                assignmentEntity.setDriver_id(rs.getInt("a.driver_id"));
//                assignmentEntity.setRoute_id(rs.getInt("a.route_id"));
                assignmentEntity.setRound(rs.getInt("a.round"));
                result.add(assignmentEntity);
            }
        }
        catch(SQLException e) {
            System.out.print("Failed");
            e.printStackTrace();
        }
        return result;
    }
}
