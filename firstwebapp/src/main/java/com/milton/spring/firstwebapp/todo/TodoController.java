package com.milton.spring.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
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
    model.addAttribute("todos", todos);

    return "listTodos";
  }

  // GET
  @RequestMapping(value = "add-todo", method = RequestMethod.GET)
  public String getAddTodo(ModelMap model) {
    String username = (String) model.get("name"); // from session
    Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
    model.put("newTodo", todo); /* 2-way binding */
    return "addTodo";
  }

  // POST
  @RequestMapping(value = "add-todo", method = RequestMethod.POST)
  public String postAddTodo(ModelMap model,
      /* @Valid: validate newTodo, which is 2-way binding */
      /* @ModelAttribute: populate the newTodo with data from a form submitted to "add-todo" endpoint. */
      /* https://stackoverflow.com/questions/2860756/spring-3-mvc-formerrors-not-showing-the-errors */
      @ModelAttribute("newTodo") @Valid Todo newTodo, BindingResult validationResult) {

    if (validationResult.hasErrors()) {
      validationResult.getAllErrors().forEach(e -> {
        if (e instanceof FieldError)
          System.out.println(
              ((FieldError) e).getField() + " ,error: " + ((FieldError) e).getDefaultMessage());
      });

      return "addTodo";
    }
    
    todoService.addTodo(
        model.get("name").toString(), newTodo.getDescription(), LocalDate.now().plusYears(1), false);

    return "redirect:list-todos";
  }
}
