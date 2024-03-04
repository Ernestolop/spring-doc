package com.py.projectstructure.mod.ztest;

import com.py.projectstructure.lib.validation.ExceptionPrototype;

public enum ZtestErrors implements ExceptionPrototype {

  text_notfound(1),
  page_notfound(2),
  size_notfound(3);

  private final int code;

  ZtestErrors(int id) {
    this.code = ZtestConstants.ERROR_RANGE + id;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getName() {
    return ZtestConstants.MODULE_NAME + "_" + name();
  }
}
