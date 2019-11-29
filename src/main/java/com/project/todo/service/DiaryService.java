package com.project.todo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.todo.model.Diary;

public interface DiaryService {
	
	List<Diary> findByUsernameOrderByDateDesc(String user);
	
	Diary getById(long id);
	 
	void updateDiary(Diary diary);
	
	void saveDiary(Diary diary);
	
	void addDiary(String name ,String desc ,MultipartFile image);
	 
	 
	 

}
