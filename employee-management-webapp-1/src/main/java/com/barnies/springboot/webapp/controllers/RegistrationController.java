package com.barnies.springboot.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barnies.springboot.webapp.model.User;
import com.barnies.springboot.webapp.dto.UserDto;
import com.barnies.springboot.webapp.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public UserDto registeredUser() {
		return new UserDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result,
			Model model) {

		User existingUser = userService.findUserByEmail(userDto.getEmail());

		if (existingUser != null)
			result.rejectValue("email", null, "User already registered with this email!");

		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "/registration";
		}

		userService.save(userDto);
		return "redirect:/registration?success";
	}

}
