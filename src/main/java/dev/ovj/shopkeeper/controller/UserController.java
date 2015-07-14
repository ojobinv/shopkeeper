package dev.ovj.shopkeeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.ovj.shopkeeper.entity.User;
import dev.ovj.shopkeeper.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return model.toString();
	}
	
	/*@RequestMapping("/users")
	public @ResponseBody List<User> users(){
		
		return userService.findAll();
		
	}*/
	
}
