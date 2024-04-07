package com.milton.spring.firstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcomePage(ModelMap model) {
    // name is saved in the session
    model.put("name", "Milton"); // hard coded for temp
    return "welcome";
  }
  /*
   * @RequestMapping(value = "login", method = RequestMethod.POST) public String
   * welcomePage(@RequestParam String name, @RequestParam String password,
   * ModelMap model) { if (authService.authenticate(name, password)) { // name is
   * saved in the session model.put("name", "Milton"); // hard coded for temp
   * return "welcome"; } model.put("errorMessage",
   * "Invalid Credentials. Please try again."); return "login"; }
   */
}
