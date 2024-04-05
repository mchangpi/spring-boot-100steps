package com.milton.spring.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  private Logger logger = LoggerFactory.getLogger(getClass());

  @RequestMapping(value = "login", method = RequestMethod.GET)
  public String loginPage() {
    return "login";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String welcomePage(@RequestParam String name, 
      @RequestParam String password, ModelMap model) {

    model.put("name", name);
    model.put("password", password);
    
    return "welcome";
  }

}

/*
 * @Controller public class LoginController { private Logger logger =
 * LoggerFactory.getLogger(getClass());
 * 
 * @RequestMapping("login") public String loginPage(@RequestParam String name,
 * ModelMap model) { System.out.println("println: req.query?name=" + name);
 * logger.info("logger: req.query?name=" + name);
 * 
 * model.put("modelName", name); return "login"; } }
 */