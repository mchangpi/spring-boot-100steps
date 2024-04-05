package com.milton.spring.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private static final List<Todo> todos = new ArrayList<>();

  private static int todosCount = 0;

  static {
    todos.add(new Todo(++todosCount, "in28minutes", 
        "Get AWS Certified 1", LocalDate.now().plusYears(1), false));
    todos.add(new Todo(++todosCount, "in28minutes", 
        "Learn DevOps 1", LocalDate.now().plusYears(2), false));
    todos.add( new Todo(++todosCount, "in28minutes", 
        "Learn Full Stack Development 1", LocalDate.now().plusYears(3), false));
  }
  
  public List<Todo> findByUsername(String username){
    return todos;
  }

}
