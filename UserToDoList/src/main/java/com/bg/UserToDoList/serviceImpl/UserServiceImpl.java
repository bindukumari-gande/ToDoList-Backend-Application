package com.bg.UserToDoList.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bg.UserToDoList.entity.Users;
import com.bg.UserToDoList.exception.UserAlreadyExistsException;
import com.bg.UserToDoList.exception.UserNotFoundException;
import com.bg.UserToDoList.repository.UsersRepository;
import com.bg.UserToDoList.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userRepo;

	@Override
	public void deleteUsers(long id) {
		if (!userRepo.existsById(id)) {
			throw new UserNotFoundException("sorry ,User not found");
		}
		userRepo.deleteById(id);
		System.out.println("User deleted Successfully");
	}
	

	@Override
	public Users addUsers(Users user) {
		if (UserAlreadyExists(user.getEmail())) {
			throw new UserAlreadyExistsException(user.getEmail() + " User are already Exists");
		}

		return userRepo.save(user);
	}

	
	private boolean UserAlreadyExists(String email) {
		return userRepo.findByEmail(email).isPresent();
	}
	

	@Override
	public List<Users> getAllUsers() {
		List<Users> users = userRepo.findAll();
		if (!users.isEmpty()) {
			
			return users;
		} else {
			throw new UserNotFoundException("No users found");
		}
	}
	

	@Override
	public Users updateUsers(Long id, Users user) {

		return userRepo.findById(id).map(u -> {
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			u.setUsername(user.getUsername());
			return userRepo.save(u);
		}).orElseThrow(() -> new UserNotFoundException("sorry, the user could not be found"));
	}
	
	

	@Override
	public Users getUserById(long id) {

		return userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("sorry ,No user could not be found with  Id " + id));
	}


//	@Override
//	public void deleteAllUsers() {
//		userRepo.deleteAll();
//		
//	}
//	
	
	
	

}
