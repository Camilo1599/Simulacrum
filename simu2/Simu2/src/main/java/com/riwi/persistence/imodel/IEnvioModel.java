package com.riwi.persistence.imodel;

import com.riwi.entities.EnvioEntity;
import com.riwi.persistence.crud.CreateModel;
import com.riwi.persistence.crud.DeleteModel;
import com.riwi.persistence.crud.ReadAllModel;
import com.riwi.persistence.crud.UpdateModel;

public interface IEnvioModel extends CreateModel<EnvioEntity>, UpdateModel<EnvioEntity>, ReadAllModel<EnvioEntity>, DeleteModel {
}
