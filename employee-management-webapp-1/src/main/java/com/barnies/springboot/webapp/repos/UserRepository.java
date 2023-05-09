package com.barnies.springboot.webapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barnies.springboot.webapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findUserByEmail(String email);

}
