package com.miniproject.todolist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.miniproject.todolist.beans.ToDoBean;
import com.miniproject.todolist.beans.TodoUserBean;
import com.miniproject.todolist.dao.ToDoUserDao;

@Controller
public class ToDoController {

	@Autowired
	ToDoUserDao toDoUserDao;
	
	@GetMapping("/")
	public ModelAndView home (HttpServletRequest request, Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username =authentication.getName();
		TodoUserBean userDetails = toDoUserDao.getUserByUsername(username);
		List<ToDoBean> listOfToDOs = toDoUserDao.getUserTodoFromId(userDetails.getUser_id());
		request.getSession().setAttribute("user", userDetails);
		ModelAndView home = new ModelAndView("ToDoList/home");
		home.addObject("user", username);
		home.addObject("Todo" ,listOfToDOs);
		home.addObject("rowCount" ,listOfToDOs.size());

		return home;
	}
	
	@GetMapping("/addToDo")
	public ModelAndView addToDo(HttpServletRequest request) {
		ModelAndView  test = new ModelAndView("ToDoList/addToDO");
		return test;
	}
	
	
	@PostMapping("/SaveToDo")
	public ModelAndView SaveToDo (@ModelAttribute ToDoBean todoBean,HttpServletRequest request) {
		String userId = ((TodoUserBean)request.getSession().getAttribute("user")).getUser_id();
		todoBean.setUser_id(userId);
		int InsertedTodo = toDoUserDao.saveToDo(todoBean);
		
		return null;
		
		
		
		
	}

	
	
}
