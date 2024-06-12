package com.bg.UserToDoList.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bg.UserToDoList.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Long> {


Optional<Users> findByEmail(String email);
}
