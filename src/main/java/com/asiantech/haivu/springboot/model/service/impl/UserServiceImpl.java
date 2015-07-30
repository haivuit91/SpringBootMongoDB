package com.asiantech.haivu.springboot.model.service.impl;

import java.util.ArrayList;
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
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), "")));
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
		//if (getUserByEmail(user.getEmail()) == null)
			return userRepository.save(user);
		//return null;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		userRepository.delete(id);
		return true;
	}

}
