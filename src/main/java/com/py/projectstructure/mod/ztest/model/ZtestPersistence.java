package com.py.projectstructure.mod.ztest.model;

import com.py.projectstructure.app.action.ActionContext;
import com.py.projectstructure.app.model.AbstractPersistence;
import com.py.projectstructure.mod.ztest.model.service.ZtestEntityService;

public class ZtestPersistence extends AbstractPersistence {

  // ::: constructor
  //

  public ZtestPersistence(ActionContext ac) {
    super(ac);
  }

  // ::: api
  //

  public ZtestEntityService getZtestEntityService(){
    return getService(ZtestEntityService.class);
  }

}
