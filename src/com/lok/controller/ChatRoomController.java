package com.lok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lok.model.User;
import com.lok.service.UserService;

@Controller
public class ChatRoomController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/chatRoom"}, method=RequestMethod.GET)
	public String getChatRoom(@RequestParam("logInId") long logInId,@RequestParam("name") String logInName,Model model){
		List<User> loggedUsers = userService.getLoggedUsers(logInId);
		model.addAttribute("logInName", logInName);
		model.addAttribute("logInId", logInId);
		model.addAttribute("loggedUsers", loggedUsers);
		return "chatRoom";
	}
	
	@RequestMapping(value={"/chatUser"}, method=RequestMethod.GET)
	public String getChatUser(@RequestParam("chatUserId") long chatUserId, Model model){
		
		return "chatUser";
	}
}
