/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.lib.validation;

import java.util.Map;

/**
 *
 * @author aledesma
 */
public class CLTException extends RuntimeException {
  
  // ::: vars
  //
  private int code = 1;
  private String name = "unknown";
  private Map<String, ?> extra;

  // ::: constructors
  //
  public CLTException() {
  }
  
  public CLTException(Throwable cause) {
    this(null, null, cause);
  }
  
  public CLTException(ExceptionPrototype proto, String msg) {
    this(proto, msg, null);
  }

  public CLTException(ExceptionPrototype proto, String msg, Throwable cause) {
    super(msg);
    if(proto != null) {
      this.code = proto.getCode();
      this.name = proto.getName();
    }
    if(cause != null) {
      initCause(cause);
    }
  }
  
  public CLTException(int code, String name) {
    this(code, name, null);
  }

  public CLTException(int code, String name, String msg) {
    this(code, name, msg, null);
  }
  
  public CLTException(int code, String name, String msg, Throwable cause) {
    super(msg);
    
    if(code > 0) {
      this.code = code;
    }
    
    if(name != null) {
      this.name = name;
    }
    
    if(cause != null) {
      initCause(cause);
    }
    
  }
  
  // ::: fields
  //
  public int getCode() {
    return code;
  }
  
  public String getName() {
    return name;
  }
  
  public Map getExtra() {
    return extra;
  }
  
  public void setExtra(Map<String, ?> extra) {
    this.extra = extra;
  }
  
}
