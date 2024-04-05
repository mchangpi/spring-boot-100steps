package com.milton.spring.firstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  @RequestMapping("login")
  public String loginPage(@RequestParam String name, ModelMap model) {
    System.out.println("req.query?name=" + name);
    
    model.put("modelName", name);
    return "login";
  }

}