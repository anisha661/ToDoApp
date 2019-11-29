package com.project.todo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todo.model.Todo;
import com.project.todo.repository.TodoRepository;

@Service
public class ToDoServiceImpl implements ToDoService{

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public List<Todo> getToDosByUser(String user) {
		
		return todoRepository.findByUsername(user);
	}

	@Override
	public Optional<Todo> getToDoById(long id) {
		
		return todoRepository.findById(id);
	}

	@Override
	public void updateTodo(Todo todo) {
        todoRepository.save(todo);		
	}

	@Override
	public void saveTodo(Todo todo) {
        todoRepository.save(todo);		

	}

	@Override
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
			todoRepository.save(new Todo(name, desc, targetDate,isDone));
	}

	@Override
	public void deleteTodo(long id) {
		Optional<Todo> todo =todoRepository.findById(id);
		if(todo.isPresent()) {
			todoRepository.delete(todo.get());
		}
		
	}

}
