package com.riwi.persistence.crud;

public interface UpdateModel <Entity>{
    void update(int id, Entity entity);
}
