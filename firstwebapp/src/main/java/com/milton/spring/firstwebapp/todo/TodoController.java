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

  /*
   * POST
   * 
   * @ModelAttribute: populate the todo with data from a form submitted to
   * "add-todo" endpoint.
   * 
   * @Valid: validate todo, which is 2-way binding
   * 
   * https://stackoverflow.com/questions/2860756/spring-3-mvc-formerrors-not-
   * showing-the-errors
   */
  @RequestMapping(value = "add-todo", method = RequestMethod.POST)
  public String postAddTodo(@ModelAttribute("newTodo") @Valid Todo todo, 
      BindingResult validationResult, ModelMap model) {

    if (validationResult.hasErrors()) {
      validationResult.getAllErrors().forEach(e -> {
        if (e instanceof FieldError) {
          FieldError fieldErr = ((FieldError) e);
          System.out.println("field: " + fieldErr.getField() + ", err: " + fieldErr.getDefaultMessage());
        }
      });

      System.out.println("desc: " + todo.getDescription());

      return "addTodo";
    }

    todoService.addTodo(
        model.get("name").toString(), todo.getDescription(), todo.getTargetDate(), false);

    return "redirect:list-todos";
  }

  @RequestMapping("delete-todo")
  public String deleteTodo(@RequestParam int id) {
    todoService.deleteById(id);

    return "redirect:list-todos";
  }

  @RequestMapping(value = "update-todo", method = RequestMethod.GET)
  public String getUpdateTodo(@RequestParam int id, ModelMap model) {
    Todo todo = todoService.findById(id);
    model.addAttribute("newTodo", todo);

    return "addTodo";
  }

  @RequestMapping(value = "update-todo", method = RequestMethod.POST)
  public String updateTodo(@ModelAttribute("newTodo") @Valid Todo todo,
      BindingResult validationResult) {
    if (validationResult.hasErrors()) {
      return "addTodo";
    }

    System.out.println("updated desc: " + todo.getDescription() + ", date: "+ todo.getTargetDate());

    todoService.updateTodo(todo);

    return "redirect:list-todos";
  }
}
