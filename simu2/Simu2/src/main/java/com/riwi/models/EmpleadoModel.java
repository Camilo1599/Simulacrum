package com.riwi.models;

import com.riwi.entities.EmpleadoEntity;
import com.riwi.persistence.configDB.DBConnection;
import com.riwi.persistence.imodel.IEmpleadoModel;
import com.riwi.persistence.utils.enums.Area;
import jdk.jfr.RecordingState;

import javax.swing.*;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoModel implements IEmpleadoModel {
    @Override
    public EmpleadoEntity create(EmpleadoEntity empleadoEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "INSERT INTO empleados (nombre_empresa, nombre, apellido, area_trabajo) VALUES (?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empleadoEntity.getNombre_empresa());
            preparedStatement.setString(2, empleadoEntity.getNombre());
            preparedStatement.setString(3, empleadoEntity.getApellido());
            preparedStatement.setString(4, empleadoEntity.getArea_trabajo().name());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Empleado Creado");
            }else{
                JOptionPane.showMessageDialog(null, "Empleado no Creado");
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return empleadoEntity;
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "DELETE FROM empleados WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Empleado Eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Empleado no Eliminado");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<EmpleadoEntity> readAll() {
        List<EmpleadoEntity> empleadoEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT * FROM empleados;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Area AreaTrabajo = Area.valueOf(resultSet.getString("area_trabajo"));
                EmpleadoEntity empleadoEntity = new EmpleadoEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre_empresa"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        AreaTrabajo
                );
                empleadoEntities.add(empleadoEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return empleadoEntities;
    }

    @Override
    public void update(int id, EmpleadoEntity empleadoEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "UPDATE empleados SET nombre_empresa = ?, nombre = ?, apellido = ?, area_trabajo = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empleadoEntity.getNombre_empresa());
            preparedStatement.setString(2, empleadoEntity.getNombre());
            preparedStatement.setString(3, empleadoEntity.getApellido());
            preparedStatement.setString(4, empleadoEntity.getArea_trabajo().name());
            preparedStatement.setInt(5, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Empleado actualizado");
            }else{
                JOptionPane.showMessageDialog(null, "Empleado no actualizado");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
