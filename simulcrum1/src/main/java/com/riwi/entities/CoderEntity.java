package com.riwi.entities;

public class CoderEntity {
    int id;
    private String name;
    private String lastname;
    private String clan;
    private String technology;

    public CoderEntity() {};

    public CoderEntity(int id, String technology, String clan, String lastname, String name) {
        this.id = id;
        this.technology = technology;
        this.clan = clan;
        this.lastname = lastname;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
