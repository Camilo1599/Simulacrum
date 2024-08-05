package com.riwi.menu;

import com.riwi.controllers.ClienteController;
import com.riwi.entities.ClienteEntity;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteMenu {
    private static ClienteController clienteController = new ClienteController();

    public static void Menu(){
        while (true){

            //variables
            int id;
            String nombre;
            String apellido;
            String direccion;
            int documento;
            long numero_telefono;
            ClienteEntity clienteEntity = null;
            List<ClienteEntity> clienteEntityList = new ArrayList<>();

            String decisionCliente = JOptionPane.showInputDialog(null, "Ingresa una opcion:  \n\n1: Crear\n2: Actualizar\n3: Eliminar\n4: Leer\n5: Salir");

            switch (decisionCliente){
                case "5":
                    return;
                case "1":
                    nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre de el cliente:  ");
                    apellido = JOptionPane.showInputDialog(null, "Ingresa el apellido de el cliente:  ");
                    direccion = JOptionPane.showInputDialog(null, "Ingresa la direccion de el cliente:  ");
                    documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento de el cliente:  "));
                    numero_telefono = Long.parseLong(JOptionPane.showInputDialog(null, "Ingresa el numero de telefono de el cliente:  "));
                    clienteEntity = new ClienteEntity(0, nombre, apellido, direccion, documento, numero_telefono);
                    clienteController.create(clienteEntity);
                    break;
                case "2":
                    id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el id de el cliente que quieres eliminar:  "));
                    nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre de el cliente:  ");
                    apellido = JOptionPane.showInputDialog(null, "Ingresa el apellido de el cliente:  ");
                    direccion = JOptionPane.showInputDialog(null, "Ingresa la direccion de el cliente:  ");
                    documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento de el cliente:  "));
                    numero_telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de telefono de el cliente:  "));
                    clienteEntity = new ClienteEntity(0, nombre, apellido, direccion, documento, numero_telefono);
                    clienteController.update(id, clienteEntity);
                    break;
                case "3":
                    id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el id de el cliente que quieres eliminar:  "));
                    clienteController.delete(id);
                    break;
                case "4":
                    clienteEntityList = clienteController.readAll();
                    String lista = "";
                    for (ClienteEntity cs : clienteEntityList){
                        lista += cs.toString()+"\n";
                    }
                    JOptionPane.showMessageDialog(null, lista);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingresa una opcion valida");
            }
        }
    }
}
