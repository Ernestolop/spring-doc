/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.app.action;

import com.py.projectstructure.app.model.PersistenceManager;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author aledesma
 */
public class ActionContext {

  // ::: vars
  //
  private final ApplicationContext appContext;
  private ActionPrincipal principal;

  // ::: constructor
  //
  public ActionContext(ApplicationContext appContext) {
    this(appContext, ActionPrincipal.newAnonymous());
  }

  public ActionContext(ApplicationContext appContext, ActionPrincipal principal) {
    this.appContext = appContext;
    this.principal = principal;
  }

  // :::
  //
  public ApplicationContext getApplicationContext() {
    return appContext;
  }

  public ActionPrincipal getPrincipal() {
    return principal;
  }

  public <T> T getService(Class<T> serviceClass) {
    return appContext.getBean(serviceClass);
  }

  public PersistenceManager getPersistences() {
    return new PersistenceManager(this);
  }


}
