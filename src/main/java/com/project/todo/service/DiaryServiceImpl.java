package com.project.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.todo.model.Diary;
import com.project.todo.repository.DiaryRepository;
@Service
public class DiaryServiceImpl  implements DiaryService{

	@Autowired
	private DiaryRepository diaryRepository;
	
	@Override
	public List<Diary> findByUsernameOrderByDateDesc(String user) {
		
		return diaryRepository.findByUsernameOrderByDateDesc(user);
	}

	@Override
	public Diary getById(long id) {
		
		return diaryRepository.findById(id).get();
	}

	@Override
	public void updateDiary(Diary diary) {
		diaryRepository.save(diary);
	}

	@Override
	public void saveDiary(Diary diary) {
		diaryRepository.save(diary);
		
	}

	@Override
	public void addDiary(String name, String desc, MultipartFile image) {
		diaryRepository.save(new Diary(name, desc, image));
	}

}
