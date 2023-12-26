package com.codewithbisht.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithbisht.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

	
}
