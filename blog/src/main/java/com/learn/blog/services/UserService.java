package com.learn.blog.services;

import java.util.List;

import com.learn.blog.payloads.UserDto;

public interface UserService {
	
	// create user
	UserDto createUser(UserDto userDto);
	
	// update user
	UserDto updateUser(UserDto userDto, Integer userId);
	
	// get single user 
	UserDto getUserById(Integer userId);
	
	// get all users 
	List<UserDto> getAllUsers();
	
	// delete user 
	void deleteUser(Integer userId);

}
