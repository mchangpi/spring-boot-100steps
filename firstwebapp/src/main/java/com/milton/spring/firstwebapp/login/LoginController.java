package com.milton.spring.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
  private Logger logger = LoggerFactory.getLogger(getClass());

  @RequestMapping("login")
  public String loginPage() {
    return "login";
  }
}

/*
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
  private Logger logger = LoggerFactory.getLogger(getClass());

  @RequestMapping("login")
  public String loginPage(@RequestParam String name, ModelMap model) {
    System.out.println("println: req.query?name=" + name);
    logger.info("logger: req.query?name=" + name);

    model.put("modelName", name);
    return "login";
  }
}*/