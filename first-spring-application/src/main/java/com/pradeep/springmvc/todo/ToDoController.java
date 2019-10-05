package com.pradeep.springmvc.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {

	@Autowired
	private ToDoService service;
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String listTodos(ModelMap modelMap) {
		//modelMap.addAttribute("name",name);
		modelMap.addAttribute("todos",service.reteriveTodos("pradeep"));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showTodoPage() {
		return "todo";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addTodo(ModelMap modelMap,@RequestParam String desc) {
		modelMap.clear();
		System.out.println(desc);
		service.addTodo("pradeep", desc, new Date(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(ModelMap modelMap,@RequestParam int id) {
		modelMap.clear();
		service.delteTodo(id);
		return "redirect:list-todos";
	}
	
	
}
