package com.matome.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matome.library.model.Student;
import com.matome.library.model.User;
import com.matome.library.repository.StudentRepository;
import com.matome.library.repository.UserRepository;
import com.matome.library.services.StudentService;

@RestController
@RequestMapping("users")
public class LoginController {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("sign-up")
	public void signUp(@RequestBody Student user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.println("Saving users");
		userRepository.save(user);
		System.out.println("Done saving users");
		
	}
	@GetMapping("login")
	public User login(User username) {
	  Student user = userRepository.findByUserName(username.getUserName());
	  return user;
	}

}
