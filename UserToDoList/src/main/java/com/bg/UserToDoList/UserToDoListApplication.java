package com.bg.UserToDoList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.bg.UserToDoList.controller","com.bg.UserToDoList.repository"})
@EntityScan("com.bg.UserToDoList.entity")
@EnableJpaRepositories("com.bg.UserToDoList.repository")
@ComponentScan(basePackages = "com.bg.UsersToDoList")
public class UserToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserToDoListApplication.class, args);
	}

}
