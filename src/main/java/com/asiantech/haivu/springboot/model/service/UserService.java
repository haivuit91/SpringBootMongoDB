package com.asiantech.haivu.springboot.model.service;

import java.util.List;

import com.asiantech.haivu.springboot.model.User;

public interface UserService {

	/**
	 * get list users
	 * 
	 * @return list users
	 */
	List<User> getUsers();

	/**
	 * get user by email
	 * 
	 * @param email
	 * @return user
	 */
	User getUserByEmail(String email);

	/**
	 * save user
	 * 
	 * @param user
	 * @return user if save user successfully
	 */
	User save(User user);

	/**
	 * delete user by email
	 * 
	 * @param email
	 * @return true if delete successfully
	 */
	boolean delete(String email);

}
