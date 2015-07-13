package dev.ovj.shopkeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		System.out.println("/WEB-INF/jsp/index.jsp");
		return "/WEB-INF/jsp/index.jsp";
	}
	
	@RequestMapping("/index.json")  
	 public @ResponseBody String sendJSON(){
		return new String("Json result");
	}
	
}
