package com.vois.user.service;

import java.util.List;

import com.vois.user.dto.UsersDto;

public interface UserService {
	UsersDto registerNewUser(UsersDto user);
	UsersDto createUser(UsersDto userDto);
	UsersDto updateUser(UsersDto userDto,Integer userId);
	UsersDto getUserById(Integer userId);
	List<UsersDto> getAllUsers();
	void deleteUserById(Integer userId);
	
}