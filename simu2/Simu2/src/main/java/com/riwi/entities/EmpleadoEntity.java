package com.riwi.entities;

import com.riwi.persistence.utils.enums.Area;

public class EmpleadoEntity {
    private int id;
    private String nombre_empresa;
    private String nombre;
    private String apellido;
    private Area area_trabajo;

    public EmpleadoEntity() {
    }

    public EmpleadoEntity(int id, String nombre_empresa, String nombre, String apellido, Area area_trabajo) {
        this.id = id;
        this.nombre_empresa = nombre_empresa;
        this.nombre = nombre;
        this.apellido = apellido;
        this.area_trabajo = area_trabajo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Area getArea_trabajo() {
        return area_trabajo;
    }

    public void setArea_trabajo(Area area_trabajo) {
        this.area_trabajo = area_trabajo;
    }

    @Override
    public String toString() {
        return "EmpleadoEntity{" +
                "id=" + id +
                ", nombre_empresa='" + nombre_empresa + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", area_trabajo=" + area_trabajo +
                "}\n";
    }
}
