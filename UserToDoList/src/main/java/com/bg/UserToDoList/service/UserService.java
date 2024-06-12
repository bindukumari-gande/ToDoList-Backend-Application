package com.bg.UserToDoList.service;

import java.util.List;

import com.bg.UserToDoList.entity.Users;

public interface UserService {

	
Users addUsers(Users user);

 void deleteUsers(long id) ;
 
 List<Users> getAllUsers();
 
 Users updateUsers(Long id,Users user);
 
 Users getUserById(long id);
 
// void deleteAllUsers();
	
	

		
	}


