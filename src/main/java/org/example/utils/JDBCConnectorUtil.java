package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectorUtil {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bus_management_jdbc";
    static final String USER = "root";
    static final String PASS = "12345";

    public static Connection getConnection(){
        Connection connect = null;
        try{
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return connect;
    }
}
