/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.projectstructure.app.action;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author aledesma
 */
public class ActionPrincipal {

  // ::: vars
  //
  private String autToken;
  private String username;
  private String name;
  private String description;
  private String email;
  private boolean emailVerified;
  private List<String> roles;
  private boolean anonymous;
  private String userId; //user id en keycloack para envio de email de verififacion


  public String getAutToken() {
    return autToken;
  }

  public void setAutToken(String autToken) {
    this.autToken = autToken;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public boolean isAnonymous() {
    return anonymous;
  }

  public void setAnonymous(boolean anonymous) {
    this.anonymous = anonymous;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public static ActionPrincipal newAnonymous() {
    var p = new ActionPrincipal();
    p.name = "--anonymous--";
    p.description = "Anonymous";
    p.roles = Collections.EMPTY_LIST;
    p.anonymous = true;
    return p;
  }
}
