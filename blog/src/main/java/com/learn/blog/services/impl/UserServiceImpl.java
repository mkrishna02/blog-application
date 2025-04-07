package com.learn.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.blog.entities.User;
import com.learn.blog.exceptions.ResourceNotFoundException;
import com.learn.blog.payloads.UserDto;
import com.learn.blog.repositories.UserRepo;
import com.learn.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper; // to conver the object on one class into other that is user entity to user dto. 
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User savedUser= this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(user.getPassword());
		User updatedUser = this.userRepo.save(user);
		UserDto userdto1 = this.userToDto(updatedUser);
		return userdto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id",userId));
		
		return this.userToDto(user);
	}
	
	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDto = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","user",userId));
		this.userRepo.delete(user);
	}
	
	// create method to convert userdto to user and user to userdto to use repositories
	
	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class); // map function map the source to destination that is user dto to user object.
		
		/*
		 * User user = new User(); 
		 * // set the values of dto into user
		 * user.setId(userDto.getId()); 
		 * user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); 
		 * user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout());
		 */
		return user;
	}

	private UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		/*
		 * UserDto userDto=new UserDto(); 
		 * userDto.setId(user.getId());
		 * userDto.setName(user.getName()); 
		 * userDto.setEmail(user.getEmail());
		 * userDto.setPassword(user.getPassword()); 
		 * userDto.setAbout(user.getAbout());
		 */
		return userDto;
	}

	
}
