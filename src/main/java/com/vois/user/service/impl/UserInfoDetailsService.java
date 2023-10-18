package com.vois.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.vois.user.entity.UserInfoUserDetails;
import com.vois.user.entity.UsersDetails;
import com.vois.user.repo.UserRepo;

@Component
public class UserInfoDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsersDetails> user = userRepo.findByUserName(username);
		return user.map(UserInfoUserDetails:: new)
		.orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
		
	}

}