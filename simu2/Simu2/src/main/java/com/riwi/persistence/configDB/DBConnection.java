package com.riwi.persistence.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection(){
        String Url = "jdbc:mysql://127.0.0.1:3306/simu2";
        String User = "root";
        String Password = "diego12345*";
        try{
            connection = DriverManager.getConnection(Url,User, Password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            if(connection != null) connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
