package com.asiantech.haivu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asiantech.haivu.springboot.model.User;
import com.asiantech.haivu.springboot.model.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * add new user
	 * 
	 * @param user
	 * @return user if save successfully
	 */
	@RequestMapping(value = "save", method = RequestMethod.GET)
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	/**
	 * add new user
	 * 
	 * @param user
	 * @return user if save successfully
	 */
	@RequestMapping(value = "get-by-email", method = RequestMethod.GET)
	public User getUserByEmail(@RequestParam("email") String email) {
		return userService.getUserByEmail(email);
	}

	/**
	 * get list users
	 * 
	 * @return list users
	 */
	@RequestMapping("list-user")
	public List<User> getUsers() {
		return userService.getUsers();
	}

}
