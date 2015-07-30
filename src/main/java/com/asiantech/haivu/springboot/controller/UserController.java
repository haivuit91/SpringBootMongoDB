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
	 * get list users
	 * 
	 * @return list users
	 */
	@RequestMapping("list-user")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	/**
	 * get user by email
	 * 
	 * @param email
	 * @return user
	 */
	@RequestMapping(value = "get-by-email", method = RequestMethod.GET)
	public User getUserByEmail(@RequestParam("email") String email) {
		return userService.getUserByEmail(email);
	}

	/**
	 * add new user
	 * 
	 * @param user
	 * @return user if save successfully
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		System.out.println(user.getEmail());
		return userService.save(user);
	}
	
	/**
	 * delete user by email
	 * 
	 * @param id
	 * @return true if delete successfully
	 */
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public boolean deleteUser(@RequestParam("email") String email) {
		return userService.delete(email);
	}

}
