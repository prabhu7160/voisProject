package com.vois.user.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vois.user.dto.UsersDto;
import com.vois.user.entity.UsersDetails;
import com.vois.user.exceptions.ResourceNotFoundException;
import com.vois.user.repo.UserRepo;
import com.vois.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;

//	@Override
//    public UsersDto getUserById(Integer userId) {
//        UsersProject user = this.userRepo.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("Users", "userId", userId));
//        return modelMapper.map(user, UsersDto.class);
//    }
	@Override
	public UsersDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		UsersDetails user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("UsersDetails","userId",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UsersDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<UsersDetails> users = this.userRepo.findAll();
		List<UsersDto> usersDto = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return usersDto;
	}

	@Override
	public void deleteUserById(Integer userId) {
		UsersDetails user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("UsersDetails","userId",userId));
		this.userRepo.delete(user);
	}
	public UsersDetails dtoToUser(UsersDto userDto)
	{
		UsersDetails user = this.modelMapper.map(userDto, UsersDetails.class);
		
		return user;
	}
	public UsersDto userToDto(UsersDetails user)
	{
		UsersDto userDto = this.modelMapper.map(user, UsersDto.class);
		
		return userDto;
	}

	@Override
	public UsersDto registerNewUser(UsersDto userDto) {
		UsersDetails user = this.dtoToUser(userDto); 
		UsersDetails savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UsersDto createUser(UsersDto userDto) {
		UsersDetails user = this.dtoToUser(userDto);
		UsersDetails savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UsersDto updateUser(UsersDto userDto, Integer userId) {
		//Users updatedUser = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
		UsersDetails updatedUser = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("UsersDetails","userId",userId));
		updatedUser.setUserName(userDto.getUserName());
		updatedUser.setMobile(userDto.getMobile());
		updatedUser.setPassword(userDto.getPassword());
		updatedUser.setEmail(userDto.getEmail());
		
		//id,name,mobile,password,email
		UsersDetails updateSavedUser = this.userRepo.save(updatedUser);
		UsersDto updatedUserDto = this.userToDto(updateSavedUser);
		
		return updatedUserDto;
	}
}