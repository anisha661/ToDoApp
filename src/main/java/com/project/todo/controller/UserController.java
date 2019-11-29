package com.project.todo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.todo.model.Diary;
import com.project.todo.model.User;
import com.project.todo.service.SecurityService;
import com.project.todo.service.UserService;

@Controller
public class UserController {
	

	
	@Autowired
	private SecurityService securityService;
	
	    @Autowired
	    private UserService userService;

	    @RequestMapping(value="signup" ,method=RequestMethod.GET)
	    public String showSignup(Model m){
	    m.addAttribute("user", new User());
	    return "Signup";
	    }

	    @PostMapping("/signup")
	    public String registration(@Valid User user, BindingResult bindingResult) {
	       

	        if (bindingResult.hasErrors()) {
	            return "Signup";
	        }

	        userService.save(user);


	        return "redirect:/login";
	    }

	    @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }

	    
	

}
