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
	 * @return user by email
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
	 * delete user
	 * 
	 * @param id
	 * @return true if delete user successfully
	 */
	boolean delete(int id);

}
