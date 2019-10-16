package com.pradeep.springmvc.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {

	@Autowired
	private ToDoService service;
	
	@InitBinder
	protected  void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
		
	}
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String listTodos(ModelMap modelMap) {
		//modelMap.addAttribute("name",name);
		modelMap.addAttribute("todos",service.reteriveTodos("pradeep"));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showTodoPage(ModelMap modelMap) {
		modelMap.addAttribute("todo", new ToDo());
		return "todo";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addTodo(ModelMap modelMap,@Valid ToDo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "todo";
		}
		modelMap.clear();
		System.out.println(todo.getDesc());
		service.addTodo("pradeep",todo.getDesc(), new Date(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String updateTodo(ModelMap modelMap,@RequestParam int id) {
		
		ToDo todo=service.reteriveTodo(id);
		modelMap.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap modelMap,@Valid ToDo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "todo";
		}
		service.updateTodo(todo);
		return "redirect:list-todos";
	}

	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(ModelMap modelMap,@RequestParam int id) {
		modelMap.clear();
		service.delteTodo(id);
		return "redirect:list-todos";
	}
	
	
}
