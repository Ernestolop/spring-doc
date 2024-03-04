/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.app.model;

import com.py.projectstructure.app.action.ActionContext;


/**
 *
 * @author aledesma
 */
public class AbstractPersistence {
  
  // ::: vars
  //
  private ActionContext ac;
  
  // ::: constructors
  //
  public AbstractPersistence(ActionContext ac) {
    this.ac = ac;
  }
  
  // ::: api
  //
  public ActionContext getActionContext() {
    return ac;
  }
  
  protected <T> T getService(Class<T> tClass) {
    return ac.getService(tClass);
  }
}
