package com.milton.springboot.restapi.helloworld;

public class HelloWorldBean {

  public HelloWorldBean(String username,String message) {
    super();
    this.username = username;
    this.message = message;
  }

  private String username;
  private String message;

  public String getUsername() {
    return username;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "HelloWorldBean [message=" + message + "]";
  }

}
