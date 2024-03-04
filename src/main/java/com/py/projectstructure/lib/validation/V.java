/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.lib.validation;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author aledesma
 */
public class V {

  // ::: true
  //
  public static final void ifTrue(boolean o, ExceptionPrototype proto) {
    ifTrue(o, proto, null, null);
  }

  public static final void ifTrue(boolean o, ExceptionPrototype proto, String msg) {
    ifTrue(o, proto, msg, null);
  }

  public static final void ifTrue(boolean o, ExceptionPrototype proto, String msg, Map extra) {
    if (o && proto != null) {
      Thrower.throwException(proto, msg, null, extra);
    }
  }

  // ::: false
  //
  public static final void ifFalse(boolean o, ExceptionPrototype proto) {
    ifFalse(o, proto, null, null);
  }

  public static final void ifFalse(boolean o, ExceptionPrototype proto, String msg) {
    ifFalse(o, proto, msg, null);
  }

  public static final void ifFalse(boolean o, ExceptionPrototype proto, String msg, Map extra) {
    ifTrue(!o, proto, msg, extra);
  }

  // ::: null
  //
  public static final void ifNull(Object o, ExceptionPrototype proto) {
    ifNull(o, proto, null, null);
  }

  public static final void ifNull(Object o, ExceptionPrototype proto, String msg) {
    ifNull(o, proto, msg, null);
  }

  public static final void ifNull(Object o, ExceptionPrototype proto, String msg, Map extra) {
    ifTrue(o == null, proto, msg, extra);
  }

  // ::: not null
  //
  public static final void ifNotNull(Object o, ExceptionPrototype proto) {
    ifNotNull(o, proto, null, null);
  }

  public static final void ifNotNull(Object o, ExceptionPrototype proto, String msg) {
    ifNotNull(o, proto, msg, null);
  }

  public static final void ifNotNull(Object o, ExceptionPrototype proto, String msg, Map extra) {
    ifTrue(o != null, proto, msg, extra);
  }

  // ::: empty
  //
  public static final void ifEmpty(Object o, ExceptionPrototype proto) {
    ifEmpty(o, proto, null, null);
  }

  public static final void ifEmpty(Object o, ExceptionPrototype proto, String msg) {
    ifEmpty(o, proto, msg, null);
  }

  public static final void ifEmpty(Object o, ExceptionPrototype proto, String msg, Map extra) {
    ifTrue(isEmpty(o), proto, msg, extra);
  }

  // ::: not empty
  //
  public static final void ifNotEmpty(Object o, ExceptionPrototype proto) {
    ifNotEmpty(o, proto, null, null);
  }

  public static final void ifNotEmpty(Object o, ExceptionPrototype proto, String msg) {
    ifNotEmpty(o, proto, msg, null);
  }

  public static final void ifNotEmpty(Object o, ExceptionPrototype proto, String msg, Map extra) {
    ifTrue(!isEmpty(o), proto, msg, extra);
  }

  // ::: checks
  //
  public static final boolean isNull(Object o) {
    return o == null;
  }

  public static final boolean isEmpty(Object o) {
    boolean rv = isNull(o);

    if (!rv) {
      if (o instanceof String) {
        rv = ((String) o).isEmpty();

      } else if (o instanceof Collection) {
        rv = ((Collection) o).isEmpty();

        //} else if (o instanceof Iterable) { check array[]
        //  rv = ((Array) o)
      }
    }

    return rv;
  }

}
