package com.riwi.persistence.crud;

import java.util.List;

public interface ReadAllModel <Entity>{
    List<Entity> readAll();
}
