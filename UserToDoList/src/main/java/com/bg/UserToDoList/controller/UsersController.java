package com.bg.UserToDoList.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bg.UserToDoList.entity.Users;
import com.bg.UserToDoList.exception.UserNotFoundException;
import com.bg.UserToDoList.repository.UsersRepository;
import com.bg.UserToDoList.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	
	
		
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
	    return userService.getAllUsers();
	}

	
	
	@PostMapping("/addUsers")
	public Users addUsers(@Valid @RequestBody  Users user) {
		return userService.addUsers(user);
	}
	
	
	
	
	
	@PutMapping("/update/{id}")
	public Users updateUsers( @Valid @RequestBody Users user,@PathVariable long id) {
		return userService.updateUsers(id,user);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteUsers(@PathVariable long id) {
		userService.deleteUsers(id);
	}
	
	
	@GetMapping("/getUser/{id}")
	public Users getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
//	@DeleteMapping("/delete")
//	public void deleteAllUsers() {
//		 userService.deleteAllUsers();
//	}
	


}
