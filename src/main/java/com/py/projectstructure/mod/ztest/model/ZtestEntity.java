package com.py.projectstructure.mod.ztest.model;

import javax.persistence.*;

@Entity
@Table(name = "ztest_entity")
public class ZtestEntity {

  // ::: vars
  //

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  // ::: constructor
  //

  public ZtestEntity() {
  }

  public ZtestEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  // ::: fields
  //

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
