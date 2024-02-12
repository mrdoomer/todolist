package com.miniproject.todolist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miniproject.todolist.beans.TodoUserBean;
import com.miniproject.todolist.config.MyUserDetailService;
import com.miniproject.todolist.dao.ToDoUserDao;
import com.miniproject.todolist.service.ToDoUserService;


@Controller
public class HomeController {

	@Autowired
	ToDoUserDao toDoUserDao;
	
	@Autowired
	ToDoUserService toDoUserService;

	
	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView  test = new ModelAndView("commons/Login");
		return test;
	}
	
	
	
	@GetMapping("/register")
	public ModelAndView register(HttpServletRequest request) {
		ModelAndView  test = new ModelAndView("commons/Register");
		return test;
	}

	

	
	@PostMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute TodoUserBean user,HttpServletRequest request) {
		
		try {
			boolean IsUserNamePresent = toDoUserDao.checkIfUserAlreadyExist(user.getUsername());
			boolean IsEmailIdPresent = toDoUserDao.checkIfEmailExist(user.getEmail());
			String errorMessage =null;
			if(IsUserNamePresent)
				errorMessage ="UserName Already Present";
			if(IsEmailIdPresent)
				errorMessage+= "  Emailid Already Present ";
			
			if (errorMessage != null) {
				request.setAttribute("errorMessage", errorMessage);
				request.setAttribute("error", "true");
			}
			
			else {
				int updatedUser = toDoUserService.saveUser(user);
				if(updatedUser > 0) {
					request.setAttribute("success", "true");
					request.setAttribute("successMessage", "User Successfully Registered");
				}
			}
		} catch (Exception e) {
e.printStackTrace()	;
}
		
		return new ModelAndView("commons/Register");
		
	}
	

	
	
}
