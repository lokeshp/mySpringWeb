package com.lok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lok.model.MailData;
import com.lok.model.User;
import com.lok.service.MailService;
import com.lok.service.UserService;

@Controller
public class MailController {

	@Autowired
	MailService mailService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/compose", method=RequestMethod.GET)
	public String showComposeMail(Model model){
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "compose";
	}
	
	@RequestMapping(value="/mailSend", method=RequestMethod.POST)
	public String sendMail(MailData mailData, Model model){
		if(!validateMailData(mailData)){
			model.addAttribute("message", "*fill all mandatory fields...");
			List<User> users = userService.getAllUsers();
			model.addAttribute("users", users);
			return "compose";
		}
		if(mailService.sendMail(mailData)){
			model.addAttribute("message", " Mail sent successfully...");
			return "welcome";			
		}
		model.addAttribute("err_message", "Error while sending mail.Please try again...");
		return "welcome";	
	}
	
	public boolean validateMailData(MailData mailData){
		if(mailData.getFromId().equals("") || mailData.getPassword().equals("") ||
				mailData.getToId().equals("") || mailData.getSubject().equals(""))
			return false;
		return true;
	}
	
}
