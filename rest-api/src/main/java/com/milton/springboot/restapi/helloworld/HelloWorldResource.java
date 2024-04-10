package com.milton.springboot.restapi.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

  @RequestMapping("/hello-world")
  public String helloWorld() {
    return new String("Hello World Milton");
  }

  @RequestMapping("/hello-world-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Milton", "Hello World");
  }

  // Path Variable or Path Params
  // /user/Ranga/todos/1

  @RequestMapping("/hello-world-path-var/{name}")
  public HelloWorldBean helloWorldPathParam(@PathVariable String name) {
    return new HelloWorldBean("Milton", "Hello World, " + name);
  }

  @RequestMapping("/hello-world-path-var/{name}/msg/{message}")
  public HelloWorldBean helloWorldMultiplePathParam(@PathVariable String name,
      @PathVariable String message) {
    return new HelloWorldBean("Milton", "Hello World " + name + "," + message);
  }

}
