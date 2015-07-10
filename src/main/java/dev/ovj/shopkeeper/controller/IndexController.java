package dev.ovj.shopkeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		System.out.println("/WEB-INF/jsp/index.jsp");
		return "/WEB-INF/jsp/index.jsp";
	}
	
}
