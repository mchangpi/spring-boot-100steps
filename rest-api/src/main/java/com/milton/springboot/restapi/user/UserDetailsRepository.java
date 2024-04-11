package com.milton.springboot.restapi.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// NOT necessary to put the @Repository annotation on interfaces that extend JpaRepositor

public interface UserDetailsRepository
    extends JpaRepository<UserDetails, Long> {
  List<UserDetails> findByRole(String role);
}
