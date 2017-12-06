package com.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redis.pojo.User;
import com.redis.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String find(Integer sid,Model model){
		List<User> user = userService.find(sid);
		System.out.println("-----------------------");
		System.out.println(user);
		model.addAttribute("user", user);
		
		return "index";
	}
	
}
