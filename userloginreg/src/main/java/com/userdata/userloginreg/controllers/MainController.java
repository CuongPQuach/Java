package com.userdata.userloginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.userdata.userloginreg.models.LoginUser;
import com.userdata.userloginreg.models.User;
import com.userdata.userloginreg.services.UserService;

@Controller

public class MainController {
	@Autowired
	private UserService uService;
	
	
	@GetMapping("/")
	public String loginRegPage(
			@ModelAttribute("registerUser") User newUser,
			@ModelAttribute("loginUser") LoginUser loginUser
			) {
		return "loginreg.jsp";
	}
		
	@GetMapping("/dashboard")
	public String dashboard(
			HttpSession session,
			Model viewModel
			) {
			if (session.getAttribute("userId") == null) {
				return "redirect:/"; 
			}
			Long userId = (Long) session.getAttribute("userId");
			viewModel.addAttribute("loggedUser", uService.findById(userId));	
			return "dashboard.jsp";
	}
	
//	Register user if valid
	@PostMapping("/register")
	public String registerUser(
			@Valid 
			                   // where data get from JSP
			@ModelAttribute("registerUser" ) User newUser,
			BindingResult result,
			@ModelAttribute ("loginUser") LoginUser loginUser,
			HttpSession session
			
			) {
//		User in the form
		User changedUser = uService.register(newUser, result); //call for addtional valid
		
		if (result.hasErrors()) {
			return "loginreg.jsp";
		}
//		user is registed in the data
		session.setAttribute("userId", changedUser.getId());
//		go to dashboard
		return "redirect:/dashboard";
	}
	
	
	
	
	
	@PostMapping ("/login")
	public String loginUser(
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result,
			@ModelAttribute("registerUser" ) User newUser,
			HttpSession session
			) 
	
			{
		User foundUser = uService.login(loginUser, result);
		if (result.hasErrors()) {
			return "loginreg.jsp";	
		}
		session.setAttribute("userId", foundUser.getId());
		return "redirect:/dashboard";
	}
	
	
	
	
	
	@GetMapping ("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
}
