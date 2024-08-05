package com.riwi.controllers;

import com.riwi.entities.ClienteEntity;
import com.riwi.models.ClienteModel;
import com.riwi.persistence.imodel.IClienteModel;

import java.util.List;

public class ClienteController {
    IClienteModel clienteModel = new ClienteModel();

    public ClienteEntity create(ClienteEntity clienteEntity) {
        return this.clienteModel.create(clienteEntity);
    }

    public void delete(int id) {
        this.clienteModel.delete(id);
    }

    public List<ClienteEntity> readAll() {
        return this.clienteModel.readAll();
    }

    public void update(int id, ClienteEntity clienteEntity) {
        this.clienteModel.update(id, clienteEntity);
    }
}
