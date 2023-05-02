package com.barnies.springboot.emailsender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.barnies.springboot.emailsender.dto.EmailDto;

@Controller
public class EmailSenderController {

	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/landingPage")
    public String registrationForm(Model model) {
        EmailDto email = new EmailDto();
        model.addAttribute("email", email);
        return "Landing_Page";
	}

	@PostMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("email") EmailDto emailDto, Model model) {

		String from = emailDto.getEmail();
		String to = "Delroybarnies3@gmail.com";

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject("QCS Customer Support");
		message.setText(emailDto.getMessage());

		mailSender.send(message);
		
		return "Landing_Page";
	}

}
