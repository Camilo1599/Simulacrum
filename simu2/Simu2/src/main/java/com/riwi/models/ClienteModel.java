package com.riwi.models;

import com.riwi.entities.ClienteEntity;
import com.riwi.persistence.configDB.DBConnection;
import com.riwi.persistence.imodel.IClienteModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel implements IClienteModel {
    @Override
    public ClienteEntity create(ClienteEntity clienteEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        try{
            String sql = "INSERT INTO clientes (nombre, apellido, direccion, documento, numero_telefono) VALUES (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, clienteEntity.getNombre());
            preparedStatement.setString(2, clienteEntity.getApellido());
            preparedStatement.setString(3, clienteEntity.getDireccion());
            preparedStatement.setInt(4, clienteEntity.getDocumento());
            preparedStatement.setLong(5, clienteEntity.getNumero_telefono());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Cliente creado");
            }else {
                JOptionPane.showMessageDialog(null, "Cliente no creado");
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
        return clienteEntity;
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "DELETE FROM clientes WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Cliente no eliminado");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(preparedStatement != null) preparedStatement.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ClienteEntity> readAll() {
        List<ClienteEntity> clienteEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "SELECT * FROM clientes;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ClienteEntity clienteEntity = new ClienteEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("direccion"),
                        resultSet.getInt("documento"),
                        resultSet.getLong("numero_telefono")
                );
                clienteEntities.add(clienteEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
                DBConnection.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return clienteEntities;
    }

    @Override
    public void update(int id, ClienteEntity clienteEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();

        try{
            String sql = "UPDATE clientes SET nombre = ?, apellido = ?, direccion = ?, documento = ?, numero_telefono = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, clienteEntity.getNombre());
            preparedStatement.setString(2, clienteEntity.getApellido());
            preparedStatement.setString(3, clienteEntity.getDireccion());
            preparedStatement.setInt(4, clienteEntity.getDocumento());
            preparedStatement.setLong(5, clienteEntity.getNumero_telefono());
            preparedStatement.setInt(6, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Cliente Actualizado");
            }else{
                JOptionPane.showMessageDialog(null, "Cliente no Actualizado");
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
