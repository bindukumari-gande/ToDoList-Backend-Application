package com.bg.UserToDoList;





import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bg.UserToDoList.entity.Users;
import com.bg.UserToDoList.repository.UsersRepository;
import com.bg.UserToDoList.service.UserService;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserToDoListApplicationTests {
	
     @MockBean
	 UsersRepository userRepo;
     
     @Autowired
     UserService userService;
    
       
        

         @Test
         public void testUpdateUsers() {
             // Mock data
             Long userId = 1L;
             Users existingUser = new Users();
             existingUser.setId(userId);
             existingUser.setName("John");

             Users updatedUser = new Users();
             updatedUser.setId(userId);
             updatedUser.setName("Jane");

             // Define mock behavior for findById
             when(userRepo.findById(userId)).thenReturn(Optional.of(existingUser));

             // Define mock behavior for save
             when(userRepo.save(any(Users.class))).thenReturn(updatedUser);

             // Call the method to be tested
             Users returnedUser = userService.updateUsers(userId, updatedUser);

             // Verify that the save method of the repository was called with the correct user
             verify(userRepo).save(existingUser);

             // Verify that the returned user is the updated user
             assertEquals(updatedUser, returnedUser, "Returned user should be the updated user");
         }
         
         
         @Test
         public void testAddUsers() {
             // Create a user object directly in the test method
             Users newUser = new Users();
             newUser.setName("John");

             // Define mock behavior for save
             when(userRepo.save(newUser)).thenReturn(newUser);

             // Call the method to be tested
             Users addedUser = userService.addUsers(newUser);

             // Verify that the save method of the repository was called with the correct user
             verify(userRepo).save(newUser);

             // Verify that the added user is the same as the returned user
             assertEquals(newUser, addedUser, "Added user should match the returned user");
         } 
         
         
         @Test
         public void testGetUsersById() {
             // Create a user object directly in the test method
             Users user = new Users();
             user.setId(1L);
             user.setName("John");

             // Define mock behavior for findById
             when(userRepo.findById(1L)).thenReturn(Optional.of(user));

             // Call the method to be tested
            Users retrievedUser = userService.getUserById(1L);

             // Verify that the findById method of the repository was called with the correct ID
             verify(userRepo).findById(1L);

             // Verify that the retrieved user is present and matches the expected user
             assertEquals(user, retrievedUser, "Retrieved user should match the expected user");
         }
         
         @Test
         public void testGetAllUsers() {
             // Create a list of users directly in the test method
             Users user1 = new Users();
             user1.setId(1L);
             user1.setName("John");

             Users user2 = new Users();
             user2.setId(2L);
             user2.setName("Jane");

             List<Users> usersList = Arrays.asList(user1, user2);

             // Define mock behavior for findAll
             when(userRepo.findAll()).thenReturn(usersList);

             // Call the method to be tested
             List<Users> retrievedUsers = userService.getAllUsers();

             // Verify that the findAll method of the repository was called
             verify(userRepo).findAll();

             // Verify that the retrieved users match the expected users
             assertEquals(usersList, retrievedUsers, "Retrieved users should match the expected users");
         }
         
         
         @Test
         public void testDeleteUsers() {
             // Create a user object directly in the test method
             Users user = new Users();
             user.setId(1L);

             // Define mock behavior for existsById
             when(userRepo.existsById(1L)).thenReturn(true);

             // Call the method to be tested
             userService.deleteUsers(1L);

             // Verify that the deleteById method of the repository was called with the correct ID
             verify(userRepo).deleteById(1L);
         }
         
         
         
         
         
         
     }
         
         
         
         
         
         
         
         
         
         
         



