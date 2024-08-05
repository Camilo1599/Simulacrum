package com.riwi.persistence.imodel;

import com.riwi.entities.TransporteEntity;
import com.riwi.persistence.crud.CreateModel;
import com.riwi.persistence.crud.DeleteModel;
import com.riwi.persistence.crud.ReadAllModel;
import com.riwi.persistence.crud.UpdateModel;

public interface ITransporteModel extends CreateModel<TransporteEntity>, UpdateModel<TransporteEntity>, ReadAllModel<TransporteEntity>, DeleteModel {
}
