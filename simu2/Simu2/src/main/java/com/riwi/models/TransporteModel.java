package com.riwi.models;

import com.riwi.entities.TransporteEntity;
import com.riwi.persistence.configDB.DBConnection;
import com.riwi.persistence.imodel.ITransporteModel;
import com.riwi.persistence.utils.enums.Disponibilidad;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransporteModel implements ITransporteModel {
    @Override
    public TransporteEntity create(TransporteEntity transporteEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "INSERT INTO transportes (tipo_vehiculo, disponibilidad) VALUES (?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transporteEntity.getTipo_vehiculo());
            preparedStatement.setString(2, transporteEntity.getDisponibilidad().name());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Transportes Creado");
            }else{
                JOptionPane.showMessageDialog(null, "Transportes no Creado");
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
        return transporteEntity;
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "DELETE FROM transportes WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Transporte Eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Transporte no Eliminado");
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
    public List<TransporteEntity> readAll() {
        List<TransporteEntity> transporteEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT * FROM transportes WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Disponibilidad disponibilidad = Disponibilidad.valueOf(resultSet.getString("disponibilidad"));
                TransporteEntity transporteEntity = new TransporteEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("tipo_vehiculo"),
                        disponibilidad
                );
                transporteEntities.add(transporteEntity);
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
        return transporteEntities;
    }

    @Override
    public void update(int id, TransporteEntity transporteEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "UPDATE transportes SET tipo_vehiculo = ?, disponibilidad = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transporteEntity.getTipo_vehiculo());
            preparedStatement.setString(2, transporteEntity.getDisponibilidad().name());
            preparedStatement.setInt(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Transporte Actuaizado");
            }else{
                JOptionPane.showMessageDialog(null, "Transporte no Actuaizado");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
