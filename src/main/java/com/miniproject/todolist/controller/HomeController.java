package com.miniproject.todolist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miniproject.todolist.config.MyUserDetailService;


@Controller
public class HomeController {


	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView  test = new ModelAndView("commons/Login");
		return test;
	}
	
	
	
	@GetMapping("/register")
	public ModelAndView register(HttpServletRequest request) {
		request.getSession().setAttribute("", request);
		ModelAndView  test = new ModelAndView("commons/Register");
		return test;
	}

	
	@GetMapping("/")
	public ModelAndView home (HttpSession session, Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username =authentication.getName();
//		String username = (String)session.getAttribute("username");
		System.out.println(username);
		ModelAndView home = new ModelAndView("ToDoList/home");
		return home;
	}
	
}
