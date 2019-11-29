package com.project.todo.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.todo.model.User;
import com.project.todo.repository.RoleRepository;
import com.project.todo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);

	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
