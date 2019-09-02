package com.pradeep.springmvc.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {

	@Autowired
	private ToDoService service;
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String listTodos(@RequestParam String name,ModelMap modelMap) {
		modelMap.addAttribute("name",name);
		modelMap.addAttribute("todos",service.reteriveTodos("pradeep"));
		return "list-todos";
	}
	
	
}
