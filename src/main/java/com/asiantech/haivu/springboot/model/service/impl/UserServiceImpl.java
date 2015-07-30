package com.asiantech.haivu.springboot.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asiantech.haivu.springboot.model.User;
import com.asiantech.haivu.springboot.model.repository.UserRepository;
import com.asiantech.haivu.springboot.model.service.UserService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		users.forEach(user -> user.setPassword(""));
		return users;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		user.setPassword("");
		return user;
	}

	@Override
	@Transactional
	public User save(User user) {
		User us = getUserByEmail(user.getEmail());
		if (us == null) {
			userRepository.save(user);
			user.setPassword("");
		}
		return user;
	}

	@Override
	@Transactional
	public boolean delete(String email) {
		User user = getUserByEmail(email);
		if (user == null)
			return false;
		userRepository.delete(user);
		return true;
	}

}
