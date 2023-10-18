package com.vois.user.controller;
//Endpoint for user

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vois.user.dto.ApiResponse;
import com.vois.user.dto.UsersDto;
import com.vois.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/userproject")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class); //slf4j implementation
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<UsersDto> createNewUser(
			@Valid @RequestBody UsersDto userDto)
	{
		UsersDto addUser = this.userService.createUser(userDto);
		logger.error("Inside add endpoint");
		logger.trace("trace implementation of log");//not enabled by default need to configure in applications.properties
		return new ResponseEntity<>(addUser,HttpStatus.CREATED);
		
	}
//PUT
	@PutMapping("/edit/{userId}")
	public ResponseEntity<UsersDto> updateUser(@RequestBody UsersDto userDto, @PathVariable Integer userId){
		UsersDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}

//DELETE
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUserById(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Area deleted successfully",true),HttpStatus.OK);
	}
//GET
	@GetMapping("/display/all")
	public ResponseEntity<List<UsersDto>> displayAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/display/{userId}")
	public ResponseEntity<UsersDto> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}