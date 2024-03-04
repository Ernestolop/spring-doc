/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.app.action;

import com.py.projectstructure.app.AppErrors;
import com.py.projectstructure.lib.validation.V;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author aledesma
 */
public class Actions {

  public static ActionContext newContext(ApplicationContext appCtxt) {
    return new ActionContext(appCtxt);
  }

  public static ActionContext newContext(ApplicationContext appCtxt, ActionPrincipal principal) {
    return new ActionContext(appCtxt, principal);
  }

  public static <A extends AbstractAction> A newAction(Class<A> aClass, ApplicationContext appCtxt) {
    return newAction(aClass, newContext(appCtxt));
  }

  public static <A extends AbstractAction> A newAction(Class<A> aClass, ActionContext ac) {
    if (aClass == null) {
      return null;
    }

    try {
      A action = aClass.getConstructor().newInstance();
      action.setContext(ac);

      return action;

    } catch (Throwable t) {
      return null;
    }
  }

  public static <A extends AbstractAction, P> A perform(Class<A> aClass, ApplicationContext appCtxt, P argument) {
    return perform(aClass, newContext(appCtxt), argument);
  }

  public static <A extends AbstractAction, P> A perform(Class<A> aClass, ActionContext ac, P argument) {
    
    A action = newAction(aClass, ac);
    V.ifNull(action, AppErrors.action_notfound);
    
    action.setArgument(argument);
    
    action.perform();
    return action;
  }

}
