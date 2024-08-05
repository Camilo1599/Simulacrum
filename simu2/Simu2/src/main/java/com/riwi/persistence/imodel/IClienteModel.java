package com.riwi.persistence.imodel;

import com.riwi.entities.ClienteEntity;
import com.riwi.persistence.crud.CreateModel;
import com.riwi.persistence.crud.DeleteModel;
import com.riwi.persistence.crud.ReadAllModel;
import com.riwi.persistence.crud.UpdateModel;

public interface IClienteModel extends CreateModel<ClienteEntity>, UpdateModel<ClienteEntity>, ReadAllModel<ClienteEntity>, DeleteModel {
}
