package com.learn.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.blog.payloads.ApiResponse;
import com.learn.blog.payloads.UserDto;
import com.learn.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	private ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
	UserDto createUserDto =	this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	private ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){  // @PathVariable("userId"): because uid is different from uri parameter
		UserDto updatedUserDto = this.userService.updateUser(userDto, uid);
		return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.OK); // ResponseEntity.ok(updatedUserDto); This will also work fine.
	}
	
	@DeleteMapping("/{userId}")
	private ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		// we have created new Response class for ApiResponse to show the message and boolean success. 
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully.", true), HttpStatus.OK);  
	}
	
	@GetMapping("/")
	private ResponseEntity<List<UserDto>> getAllUser(){
	//	List<UserDto> allUsers= this.userService.getAllUsers(); // This is also correct but no need to do this 
		return ResponseEntity.ok(this.userService.getAllUsers());	
	}
	
	// we also need to handle the exception when a userId is not present in db. For this case, created a global exception to handle such things.
	@GetMapping("{userId}")
	private ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
}
