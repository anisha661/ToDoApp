package com.project.todo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.todo.model.Diary;
import com.project.todo.model.User;
import com.project.todo.service.DiaryService;
import com.project.todo.service.SecurityService;
import com.project.todo.service.UserService;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping("/diary/{id}")
    public String userAccount(Model m, @PathVariable("id") long id) {
		Diary diary=diaryService.getById(id);
		m.addAttribute("diary", diary);
        return "showdiary";
    }
	
	@RequestMapping(value="/showDiary" ,method=RequestMethod.GET)
	public String Diary(ModelMap m ) {
		String name =securityService.findLoggedInUsername();
		m.put("diaries",diaryService.findByUsernameOrderByDateDesc(name));
		return "Diary";
	}
	
	
	@GetMapping({"/"})
    public String welcome(Model model) {
    	String username=securityService.findLoggedInUsername();
    	

        User dbUser = userService.findByUsername(username);
    	model.addAttribute("user", dbUser);
    	model.addAttribute("diary", new Diary());
        return "homepage";
    }
	
	@RequestMapping(value="/" ,method=RequestMethod.POST)
	public String addDiary(Model m ,@Valid Diary diary ,BindingResult result) {
		if(result.hasErrors()) {
			return "homepage";
		}
		
		diary.setUsername(securityService.findLoggedInUsername());
	String username=securityService.findLoggedInUsername();
    	

        User dbUser = userService.findByUsername(username);
    	m.addAttribute("user", dbUser);
		diaryService.saveDiary(diary);
		MultipartFile image = diary.getImage();

		try {
			byte[] bytes = image.getBytes();
			String name = diary.getId()+ ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("images/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showdiary";
		
	}
	
	@RequestMapping(value="/update-diary" ,method=RequestMethod.GET)
	public String updateDiary(@RequestParam long id ,Model m) {
		Diary diary=diaryService.getById(id);
		m.addAttribute("diary", diary);
		return "homepage";
		
	}
	
	@RequestMapping(value="/update-diary" ,method=RequestMethod.POST)
	public String updateDiary(Model m ,@Valid Diary diary ,BindingResult result) {
		if(result.hasErrors()) {
			return "homepage";
		}
		
		diary.setUsername(securityService.findLoggedInUsername());
		diary.setDate(new Date());
		diaryService.updateDiary(diary);

		MultipartFile image = diary.getImage();
		
		if(!image.isEmpty()) {
			try {
				byte[] bytes = image.getBytes();
				String name = diary.getId()+ ".png";
				
				Files.delete(Paths.get("images/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("images/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "showdiary";
		
	}
	
	
	

}
