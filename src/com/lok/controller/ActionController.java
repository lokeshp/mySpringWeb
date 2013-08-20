package com.lok.controller;

import java.util.List;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lok.model.User;
import com.lok.service.UserService;

@Controller
public class ActionController {

	@Autowired
	UserService userService;
	
	private static String logInName = "";
	private static long id;

	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	public String sayLogin(){
		logInName = "";
		id = 0;
		return "login";
	}
	
	@RequestMapping(value={"/welcome"}, method=RequestMethod.GET)
	public String sayWelcome(Model model){
		model.addAttribute("logInName", logInName);
		model.addAttribute("logInId", id);
		return "welcome";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(User user, Model model){
		if(user.getUserName().equals("") || user.getPassword().equals("")){
			model.addAttribute("error_msg","Enter Username and Password");
		}else{
			user = userService.getLogInUser(user);
			if(user.getId() != 0){
				logInName = user.getName();
				id = user.getId();
				model.addAttribute("userData", user);
				model.addAttribute("logInName", logInName);
				model.addAttribute("logInId", id);
				return "welcome";
			}
			model.addAttribute("error_msg","Wrong Username or Password");
		}		
		return "login";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String getRegisterPage(Model model){
		if(!logInName.equals("") || id != 0){
			model.addAttribute("logInName", logInName);
			model.addAttribute("logInId", id);
		}
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerMe(User user ,Model model){
		if(!validateData(user)){
			model.addAttribute("message", "fill all fields...");
			model.addAttribute("logInName", logInName);
			model.addAttribute("logInId", id);
			return "register";
		}
		userService.saveUser(user);
		model.addAttribute("userData", user);
		model.addAttribute("logInName", logInName);
		model.addAttribute("logInId", id);
		model.addAttribute("message", user.getName()+" have registered successfully...");
		return "welcome";
	}
	
	
	@RequestMapping(value="/updateUser", method=RequestMethod.GET)
	public String getUpdatePage(User user, Model model){
		user = userService.getUserById(user.getId());
		model.addAttribute("userData", user);
		model.addAttribute("logInName", logInName);
		model.addAttribute("logInId", id);
		return "edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUser(User user, Model model){
		if(!validateData(user)){
			model.addAttribute("message", "fill all fields...");
			model.addAttribute("userData", user);
			model.addAttribute("logInName", logInName);
			model.addAttribute("logInId", id);
			return "edit";
		}
		userService.updateUser(user);
		model.addAttribute("message", user.getName()+"'s data updated successfully...");
		model.addAttribute("userData", user);
		model.addAttribute("logInName", logInName);
		model.addAttribute("logInId", id);
		return "welcome";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getAllUsers(Model model){
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("logInName", logInName);
		model.addAttribute("logInId", id);
		return "list";
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(User user, Model model){
		if(user.getId() != 0){
			userService.deleteUser(user);
			List<User> users = userService.getAllUsers();
			model.addAttribute("users", users);
			//model.addAttribute("message", "User deleted successfully...");
			model.addAttribute("logInName", logInName);
			model.addAttribute("logInId", id);
		}
		return "list";
	}
	
	
	@RequestMapping("/welcome")
	public String sayWelcome(@RequestParam("name") String name, Model model){
		String msg = "Hi...." + name;
		System.out.println("Name : " + name);
		model.addAttribute("message", msg);
		return "welcome";
	}
	
	public boolean validateData(User user){
		if(user.getName().equals("") || user.getUserName().equals("") || 
		user.getPassword().equals("")|| user.getEmail().equals("") || user.getLocation().equals(""))
			return false;
		return true;
	}
	
	@RequestMapping(value={"/signout"}, method=RequestMethod.GET)
	public String sayBye(@RequestParam("logInId") long logInId){
		logInName = "";
		id = 0;
		userService.userLoggedout(logInId);
		return "login";
	}	
	
}
