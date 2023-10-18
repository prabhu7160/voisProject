package com.vois.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vois.user.entity.UsersDetails;

public interface UserRepo extends JpaRepository<UsersDetails, Integer> {

	Optional<UsersDetails> findByUserName(String username);

}	
	
	
	//	Optional<UsersProject> findByEmail(String email);
//	
//	@Query("select u from UsersProject u where u.email = : email ")
//	public UsersProject getUserByUserName(@Param("email") String email);

