package com.bg.UserToDoList.exception;

import org.springframework.beans.factory.annotation.Autowired;

import com.bg.UserToDoList.repository.UsersRepository;

public class UserAlreadyExistsException extends RuntimeException{
	
	public UserAlreadyExistsException(String message) {
		super(message);
	}
	
	
}
