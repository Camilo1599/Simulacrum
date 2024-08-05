package com.riwi.entities;

public class ClienteEntity {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private int documento;
    private long numero_telefono;

    public ClienteEntity() {
    }

    public ClienteEntity(int id, String nombre, String apellido, String direccion, int documento, long numero_telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.numero_telefono = numero_telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public long getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(long numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    @Override
    public String toString() {
        return
                "Client id: " + id +
                ", nombre : '" + nombre+
                ", apellido : '" + apellido +
                ", direccion : '" + direccion +
                ", documento : " + documento +
                ", numero_telefono : " + numero_telefono +
                "\n";
    }
}
