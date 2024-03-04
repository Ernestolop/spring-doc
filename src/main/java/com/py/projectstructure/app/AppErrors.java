/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.py.projectstructure.app;

import com.py.projectstructure.lib.validation.ExceptionPrototype;

/**
 *
 * @author aledesma
 */
public enum AppErrors implements ExceptionPrototype {

  none(0), // no error
  unknown(1),
  action_notfound(201),
  action_arg_notfound(202),
  //entities 300
  entity_existent(301);

  private final int code;

  AppErrors(int code) {
    this.code = AppConstants.APP_CODE + code;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getName() {
    return name();
  }
}
