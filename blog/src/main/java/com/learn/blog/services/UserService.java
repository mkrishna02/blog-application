package com.learn.blog.services;

import java.util.List;

import com.learn.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);

}
