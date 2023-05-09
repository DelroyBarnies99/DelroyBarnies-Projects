package com.barnies.springboot.webapp.service;

import com.barnies.springboot.webapp.dto.UserDto;
import com.barnies.springboot.webapp.model.User;

public interface UserService {
	
	public void save(UserDto user);
	User findUserByEmail(String email);

}
