package com.project.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.todo.model.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
	
	List<Diary> findByUsernameOrderByDateDesc(String user);
	
	

}
