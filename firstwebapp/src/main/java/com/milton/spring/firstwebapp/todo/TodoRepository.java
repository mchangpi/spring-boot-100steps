package com.milton.spring.firstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Type Parameters:
 * <T> the domain type the repository manages
 * <ID> the type of the id of the entity the repository manages
 */
public interface TodoRepository extends JpaRepository<Todo, Integer>{
  // Spring Data JPA automatically implements the function
  public List<Todo> findByUsername(String username);
}
