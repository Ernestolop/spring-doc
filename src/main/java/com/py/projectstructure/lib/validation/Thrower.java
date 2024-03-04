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
public class Thrower {

  public static void throwException(ExceptionPrototype proto) {
    throwException(proto, null);
  }

  public static void throwException(ExceptionPrototype proto, String msg) {
    throwException(proto, msg, null);
  }

  public static void throwException(ExceptionPrototype proto, String msg, Throwable cause) {
    throwException(proto, msg, cause, null);
  }

  public static void throwException(ExceptionPrototype proto, String msg, Throwable cause, Map extra) {
    CLTException ex = new CLTException(proto, msg, cause);
    ex.setExtra(extra);
    throw ex;
  }
}
