package com.project.todo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.project.todo.model.Todo;

public interface ToDoService {
	
	List<Todo> getToDosByUser(String user);
	
	Optional<Todo> getToDoById(long id);
	
	void updateTodo(Todo todo);
	
	void saveTodo(Todo todo);
	
	void addTodo(String name ,String desc,Date targetDate, boolean isDone);
	
	void deleteTodo(long id);

}
