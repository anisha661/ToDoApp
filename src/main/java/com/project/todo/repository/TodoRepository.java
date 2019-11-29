package com.project.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	List<Todo> findByUsername(String user);

}
