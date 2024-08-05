package com.riwi.entities;

import com.riwi.persistence.utils.enums.Envio;

import java.sql.Date;

public class EnvioEntity {
    private int id;
    private Date fecha_envio;
    private Date fecha_entrega;
    private Envio estado;
    private int transporte_id;
    private int cliente_id;

    public EnvioEntity() {
    }

    public EnvioEntity(int id, Date fecha_envio, Date fecha_entrega, Envio estado, int transporte_id, int cliente_id) {
        this.id = id;
        this.fecha_envio = fecha_envio;
        this.fecha_entrega = fecha_entrega;
        this.estado = estado;
        this.transporte_id = transporte_id;
        this.cliente_id = cliente_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Envio getEstado() {
        return estado;
    }

    public void setEstado(Envio estado) {
        this.estado = estado;
    }

    public int getTransporte_id() {
        return transporte_id;
    }

    public void setTransporte_id(int transporte_id) {
        this.transporte_id = transporte_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    @Override
    public String toString() {
        return "EnvioEntity{" +
                "id=" + id +
                ", fecha_envio=" + fecha_envio +
                ", fecha_entrega=" + fecha_entrega +
                ", estado=" + estado +
                ", transporte_id=" + transporte_id +
                ", cliente_id=" + cliente_id +
                "}\n";
    }
}
