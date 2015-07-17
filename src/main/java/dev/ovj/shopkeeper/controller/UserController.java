package dev.ovj.shopkeeper.controller;

import java.io.PrintStream;
import java.lang.reflect.Type;
import java.util.List;

import javax.print.PrintException;

import org.dom4j.rule.Mode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import dev.ovj.shopkeeper.entity.Role;
import dev.ovj.shopkeeper.entity.User;
import dev.ovj.shopkeeper.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	

	@RequestMapping("/users")
	public String users(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		JSONObject usersJson = new JSONObject();
		JSONArray userJsonArray = new JSONArray();
		try {
			for (User user : users) {
				// json = gson.toJson(roles);
				JSONArray jsonRoleArray = new JSONArray();
				JSONObject userJson = new JSONObject();
				userJson.put("name", user.getName());
				userJson.put("email", user.getEmail());

				List<Role> roles = user.getRoles();
				String[] roleArray = new String[roles.size()];
				for (Role role : roles) {
					String roleName = role.getRole_name();
					jsonRoleArray.put(roleName);
				}
				userJson.put("roles", jsonRoleArray);
				userJsonArray.put(userJson);
			}

			usersJson.put("users", userJsonArray);
			System.out.println("Output:" + usersJson.toString());
			/*
			 * Type listType = new TypeToken<List<User>>() {}.getType(); json =
			 * gson.toJson(users, listType); System.out.println(json);
			 */
		} catch (Exception e) {

			e.printStackTrace();
		}
		return users.toString();
	}

	
	  @RequestMapping("/users/{id}") 
	  public @ResponseBody String detail(Model model, @PathVariable int id){
	  model.addAttribute("user", userService.findOne(id));
	  return "user";
  
	  }
	 

}
