package com.example.search.domains;

public class Member {

  private int id;
  private String name;

  public Member(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Member(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
