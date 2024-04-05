package com.milton.spring.firstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  
  public boolean authenticate(String username, String password) {
    boolean isValidUserName = username.equalsIgnoreCase("milton");
    boolean isValidPassword = password.equalsIgnoreCase("test");
    
    return isValidUserName && isValidPassword;
  }

}
