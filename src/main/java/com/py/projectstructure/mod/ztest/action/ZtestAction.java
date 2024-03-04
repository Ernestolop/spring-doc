package com.py.projectstructure.mod.ztest.action;

import com.py.projectstructure.app.action.AbstractAction;
import com.py.projectstructure.lib.validation.V;
import com.py.projectstructure.mod.ztest.ZtestErrors;
import com.py.projectstructure.mod.ztest.model.ZtestEntity;
import org.springframework.data.domain.Page;

public class ZtestAction extends AbstractAction<ZtestArgument, Page> {

  // ::: vars
  //

  private Page<ZtestEntity> entities;

  // ::: api
  //

  @Override
  protected void checkArgument() {
    V.ifNull(getArgument().getPage(), ZtestErrors.page_notfound);
    V.ifNull(getArgument().getSize(), ZtestErrors.size_notfound);
  }

  @Override
  protected void doAction() {
    entities = findAll(getArgument().getPage(), getArgument().getSize());
  }

  @Override
  protected void setResultOnly() {
    setResult(entities);
  }

  // ::: internals
  //

  protected Page<ZtestEntity> findAll(Integer page, Integer size){
    var service = getContext().getPersistences().getZtestPersistence().getZtestEntityService();
    return service.findAll(page, size);
  }

}
