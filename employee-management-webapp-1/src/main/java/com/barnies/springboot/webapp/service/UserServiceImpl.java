package com.barnies.springboot.webapp.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.barnies.springboot.webapp.dto.UserDto;
import com.barnies.springboot.webapp.model.Role;
import com.barnies.springboot.webapp.model.User;
import com.barnies.springboot.webapp.repos.RoleRepository;
import com.barnies.springboot.webapp.repos.UserRepository;
import com.barnies.springboot.webapp.util.TbConstants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(UserDto registeredUser) {
		
		Role role = roleRepository.findByEmail(TbConstants.Roles.USER);
		if (role == null)
			role = roleRepository.save(new Role(TbConstants.Roles.USER));
		User user = new User(registeredUser.getUsername(), passwordEncoder.encode(registeredUser.getPassword()), registeredUser.getEmail(), Arrays.asList(role));
		userRepository.save(user);

	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

}
