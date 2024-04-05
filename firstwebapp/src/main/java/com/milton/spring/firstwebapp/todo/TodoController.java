package com.milton.spring.firstwebapp.todo;

import java.util.List;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
  
  private TodoService todoService;
  
  // constructor injection
  public TodoController(TodoService todoService) {
    super();
    this.todoService = todoService;
  }

  @RequestMapping("list-todos")
  public String listAllTodos(ModelMap model) {
    List<Todo> todos = todoService.findByUsername("milton");
    model.put("name", "milton");
    model.addAttribute("todos", todos);
    
    return "listTodos";
  }
  
}
