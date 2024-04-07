package com.milton.spring.firstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
  // private Logger logger = LoggerFactory.getLogger(getClass());

  // @Autowired
  private AuthenticationService authService;
  
  // Constructor injection
  public LoginController(AuthenticationService authenticationService) {
    super();
    this.authService = authenticationService;
  }

  @RequestMapping(value = "login", method = RequestMethod.GET)
  public String loginPage() {
    return "login";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
    if (authService.authenticate(name, password)) {
      // name is saved in the session
      model.put("name", name); 
      return "welcome";
    }
    model.put("errorMessage", "Invalid Credentials. Please try again.");
    return "login";
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