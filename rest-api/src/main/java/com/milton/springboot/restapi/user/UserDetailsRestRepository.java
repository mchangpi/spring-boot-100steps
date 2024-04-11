package com.milton.springboot.restapi.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

// NOT necessary to put the @Repository annotation on interfaces 

public interface UserDetailsRestRepository
    extends PagingAndSortingRepository<UserDetails, Long> {

  List<UserDetails> findByRole(String role);
}
