package com.asiantech.haivu.springboot.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.asiantech.haivu.springboot.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	
	User findByEmail(@Param("email") String email);

}
