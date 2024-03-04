/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.app.action;

/**
 *
 * @author aledesma
 */
public class AbstractAction<A, R> {
  
  // ::: vars
  //
  private ActionContext context;
  private A argument;
  private R result;
  
  // ::: fields
  //
  public ActionContext getContext() {
    return context;
  }
  
  public void setContext(ActionContext ac) {
    this.context = ac;
  }
  
  public A getArgument() {
    return argument;
  }
  
  public void setArgument(A argument) {
    this.argument = argument;
  }
  
  public R getResult() {
    return result;
  }
  
  protected void setResult(R result) {
    this.result = result;
  }
  
  // ::: public
  //
  public void perform() {
    checkArgument();
    
    doAction();
    
    setResultOnly();
  }
  
  // ::: protected
  //
  protected void checkArgument() {
  }
  
  protected void doAction() {
  }
  
  protected void setResultOnly() {
    
  }
  
  // ::: protected
  
}
