package com.milton.spring.firstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
  // LDAP or Database
  // In Memory

  // InMemoryUserDetailsManager
  // InMemoryUserDetailsManager(UserDetails... users)

  @Bean
  public InMemoryUserDetailsManager createUserDetailsManager() {
    UserDetails userDetails1 = createNewUser("milton", "milton");
    UserDetails userDetails2 = createNewUser("test", "test");

    return new InMemoryUserDetailsManager(userDetails1, userDetails2);
  }

  private UserDetails createNewUser(String username, String password) {
    Function<String, String> encoder = input -> passwordEncoder().encode(input);

    UserDetails userDetails = User.builder().passwordEncoder(encoder)
        .username(username).password(password).roles("USER", "ADMIN").build();

    return userDetails;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
