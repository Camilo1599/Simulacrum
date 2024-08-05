package com.riwi.persistence.imodel;

import com.riwi.entities.EmpleadoEntity;
import com.riwi.persistence.crud.CreateModel;
import com.riwi.persistence.crud.DeleteModel;
import com.riwi.persistence.crud.ReadAllModel;
import com.riwi.persistence.crud.UpdateModel;

public interface IEmpleadoModel extends CreateModel<EmpleadoEntity>, UpdateModel<EmpleadoEntity>, ReadAllModel<EmpleadoEntity>, DeleteModel {
}
