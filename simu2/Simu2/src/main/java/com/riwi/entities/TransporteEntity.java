package com.riwi.entities;

import com.riwi.persistence.utils.enums.Disponibilidad;

public class TransporteEntity {
    private int id;
    private String tipo_vehiculo;
    private Disponibilidad disponibilidad;

    public TransporteEntity() {
    }

    public TransporteEntity(int id, String tipo_vehiculo, Disponibilidad disponibilidad) {
        this.id = id;
        this.tipo_vehiculo = tipo_vehiculo;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "TransporteEntity{" +
                "id=" + id +
                ", tipo_vehiculo='" + tipo_vehiculo + '\'' +
                ", disponibilidad=" + disponibilidad +
                "}\n";
    }
}
