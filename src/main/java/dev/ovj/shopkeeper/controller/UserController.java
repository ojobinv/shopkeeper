package dev.ovj.shopkeeper.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.print.PrintException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dev.ovj.shopkeeper.entity.User;
import dev.ovj.shopkeeper.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		Gson gson = new Gson();
		String json;
		/*for(User user: users){
			json = gson.toJson(user);
			System.out.println(json);			
		}*/
		
		Type listType = new TypeToken<List<User>>() {}.getType();
		json = gson.toJson(users, listType);
		System.out.println(json);
		
		return users.toString();
	}
	
	/*@RequestMapping("/users")
	public @ResponseBody List<User> users(){
		
		return userService.findAll();
		
	}*/
	
}
