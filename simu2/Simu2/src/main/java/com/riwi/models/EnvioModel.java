package com.riwi.models;

import com.riwi.entities.EnvioEntity;
import com.riwi.persistence.configDB.DBConnection;
import com.riwi.persistence.imodel.IEnvioModel;
import com.riwi.persistence.utils.enums.Envio;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnvioModel implements IEnvioModel {
    @Override
    public EnvioEntity create(EnvioEntity envioEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "INSERT INTO envios (fecha_envio, fecha_entrega, estado, transporte_id, cliente_id) VALUES (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, envioEntity.getFecha_envio());
            preparedStatement.setDate(2, envioEntity.getFecha_entrega());
            preparedStatement.setString(3, envioEntity.getEstado().name());
            preparedStatement.setInt(4, envioEntity.getTransporte_id());
            preparedStatement.setInt(5, envioEntity.getCliente_id());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Envio Creado");
            }else{
                JOptionPane.showMessageDialog(null, "Envio no Creado");
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
        return envioEntity;
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "DELETE FROM envios WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Envio eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Envio no eliminado");
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
    public List<EnvioEntity> readAll() {
        List<EnvioEntity> envioEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT * FROM envios";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Envio estadoEnvio = Envio.valueOf(resultSet.getString("estado"));
                EnvioEntity envioEntity = new EnvioEntity(
                        resultSet.getInt("id"),
                        resultSet.getDate("fecha_envio"),
                        resultSet.getDate("fecha_entrega"),
                        estadoEnvio,
                        resultSet.getInt("transporte_id"),
                        resultSet.getInt("cliente_id")
                );
                envioEntities.add(envioEntity);
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
        return envioEntities;
    }

    @Override
    public void update(int id, EnvioEntity envioEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "UPDATE envios SET fecha_envio = ?, fecha_entrega = ?, estado = ?, transporte_id = ?, cliente_id = ? WHERE id = ?,";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, envioEntity.getFecha_envio());
            preparedStatement.setDate(2, envioEntity.getFecha_entrega());
            preparedStatement.setString(3, envioEntity.getEstado().name());
            preparedStatement.setInt(4, envioEntity.getTransporte_id());
            preparedStatement.setInt(5, envioEntity.getCliente_id());
            preparedStatement.setInt(6, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Envios Actualizado");
            }else{
                JOptionPane.showMessageDialog(null, "Envios no Actualizado");
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
