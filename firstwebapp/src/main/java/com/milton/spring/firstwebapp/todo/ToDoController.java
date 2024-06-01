//package com.miltontest.springboot.miltonfirstwebapp.todo;
package com.milton.spring.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ToDoController {
  
  private Logger logger = LoggerFactory.getLogger(getClass());
  private ToDoService toDoService;
  
  @Autowired
  public ToDoController(ToDoService toDoService) {
    super();
    this.toDoService = toDoService;
  }

  @RequestMapping("listtodos")
  public String listAllToDos(ModelMap model){
    List<ToDo> toDos = toDoService.findByUsername(getLoggedinUsername());
    model.addAttribute("toDos", toDos);
    return "listToDos";
  }

  @RequestMapping(value = "addtodo", method = RequestMethod.GET)
  public String newToDo(ModelMap model){
    ToDo toDo = new ToDo(0, (String) model.get("name"), "", LocalDate.now().plusMonths(1), false);
    model.put("toDo", toDo); //2-way binding, <form:form method = "post" modelAttribute = "toDo">
    return "addToDo";
  }

  @RequestMapping(value = "addtodo", method = RequestMethod.POST)
  public String addToDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {
    
    if(result.hasErrors()) {
      return "addToDo";
    }
    
    toDoService.addToDo((String) model.get("name"), 
        toDo.getDescription(), toDo.getTargetDate(), false);
    return "redirect:listtodos";
  }

  @RequestMapping(value = "updatetodo", method = RequestMethod.GET)
  public String showUpdateToDo(@RequestParam int id, ModelMap model) {
    ToDo toDo = toDoService.findById(id); 
    model.addAttribute("toDo", toDo);
    return "addToDo";
  }

  @RequestMapping(value = "updatetodo", method = RequestMethod.POST)
  public String updateToDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {

    if(result.hasErrors()) {
      return "addToDo";
    }
    toDo.setUsername((String) model.get("name"));
    toDoService.updateToDo(toDo); 
    
    logger.info((String)model.get("name"));
    logger.info(toDo.toString());
    return "redirect:listtodos";
  }

  @RequestMapping("deletetodo")
  public String deleteToDo(@RequestParam int id){
    toDoService.deleteById(id);
    return "redirect:listtodos";
  }

  private String getLoggedinUsername() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return auth.getName();
  }
}
