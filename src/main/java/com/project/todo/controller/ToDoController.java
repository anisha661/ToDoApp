package com.project.todo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.todo.model.Todo;
import com.project.todo.service.SecurityService;
import com.project.todo.service.ToDoService;

@Controller
public class ToDoController {
    
	@Autowired
	SecurityService securityService;
	
	@Autowired
	ToDoService todoService;
	
	
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/showToDo" , method=RequestMethod.GET)
	public String showToDo(ModelMap m) {
		String name =securityService.findLoggedInUsername();
		m.put("todos", todoService.getToDosByUser(name));
		return "list-todos";
	}

	
	@RequestMapping(value="/add-todo" , method=RequestMethod.GET)
	public String showAddTodo(ModelMap m) {
		m.addAttribute("todo" ,new Todo());
		return "todo";
	}
	
	@RequestMapping(value="/update-todo" ,method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam long id,ModelMap m) {
		Todo todo =todoService.getToDoById(id).get();
		m.addAttribute("todo", todo);
		return "todo";
		
	}
	
	@RequestMapping(value="/update-todo" ,method=RequestMethod.POST)
	public String updateTodo( @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		todo.setUsername(securityService.findLoggedInUsername());
		todoService.updateTodo(todo);
		return "redirect:/showToDo";
		
	}
	
	@RequestMapping(value="/add-todo" ,method=RequestMethod.POST)
	public String addTodo(ModelMap m, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		todo.setUsername(securityService.findLoggedInUsername());
		todoService.saveTodo(todo);
		return "redirect:/showToDo";
		
	}
	
	@RequestMapping(value="/delete-todo" , method=RequestMethod.GET)
	public String deleteTodo(@RequestParam long id) {
		
		todoService.deleteTodo(id);
		return "redirect:/showToDo";
		
	}
}









