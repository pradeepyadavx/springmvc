package com.pradeep.springmvc.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	private static List<ToDo> todos= new ArrayList<ToDo>();
	private static int todoCount=3;
	
	
	static {
		todos.add(new ToDo(1, "pradeep", "Learn Spring mvc", new Date(), false));
		todos.add(new ToDo(2, "pradeep", "Learn Spring boot", new Date(), false));
		todos.add(new ToDo(3, "pradeep", "Learn Spring jpa", new Date(), false));
	}
	
	public void addTodo(String name,String desc,Date targetDate,boolean isDone) {
		System.out.println("call come");
		todos.add(new ToDo(++todoCount, name, desc, targetDate, isDone));
		System.out.println(todos.toString());
	}
	
	
	public List<ToDo> reteriveTodos(String user){
		List<ToDo> filterTodos= new ArrayList<ToDo>();
		for(ToDo to:todos) {
			if(to.getUser().equals(user)) {
				filterTodos.add(to);
			}
		}
		return filterTodos;
	}
	
	public void delteTodo(int id) {
		Iterator<ToDo> iterator= todos.iterator();
		while(iterator.hasNext()){
			ToDo todo=iterator.next();
			if (todo.getId()==id) {
				iterator.remove();
			}
		}
	}

}
