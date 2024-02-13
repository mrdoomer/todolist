package com.miniproject.todolist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ToDoController {

	@Autowired
	ToDoUserDao toDoUserDao;
	
	@GetMapping("")
	public ModelAndView home (HttpServletRequest request, Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username =authentication.getName();
		TodoUserBean userDetails = toDoUserDao.getUserByUsername(username);
		List<ToDoBean> listOfToDOs = toDoUserDao.getUserTodoFromId(userDetails.getUser_id());
		request.getSession().setAttribute("user", userDetails);
		ModelAndView home = new ModelAndView("ToDoList/home");
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
		if(InsertedTodo > 0 ) {
			request.setAttribute("success", "true");
			request.setAttribute("successMessage", "Successfully added Todo");
		}
		else {
			request.setAttribute("error", "true");
			request.setAttribute("errorMessage", "Failed to add todo");
		}
		return new ModelAndView("ToDoList/addToDO");

		
	}
	
	
	@GetMapping("/TodoForm")
	public ModelAndView TodoForm(HttpServletRequest request){
		TodoUserBean userDetails = toDoUserDao.getUserByUsername(((TodoUserBean)request.getSession().getAttribute("user")).getUsername());
		List<ToDoBean> listOfToDOs = toDoUserDao.getUserTodoFromId(userDetails.getUser_id());
		request.getSession().setAttribute("user", userDetails);
		ModelAndView home = new ModelAndView("ToDoList/todoForm");
		home.addObject("Todo" ,listOfToDOs);
		home.addObject("rowCount" ,listOfToDOs.size());
		return home;
	}
	
	@GetMapping("/logout-success")
	public ModelAndView logout() {
		return new ModelAndView("redirect:/login");
	}
	
	
@ResponseBody
@PostMapping("/updateTodo")
public ResponseEntity<String> updateToDo(@ModelAttribute ToDoBean toDoBean){
	System.out.println("toDoBean"+toDoBean);
	try {
		int updatedTodo=  toDoUserDao.updateToDoById(toDoBean);
		if(updatedTodo>0) {
			return new ResponseEntity<String>("Successfully Updated ToDo", HttpStatus.OK);
		
	}} catch (Exception e) {
		e.printStackTrace();
	
	}
	return new ResponseEntity<String>("Failed to Update Todo", HttpStatus.INTERNAL_SERVER_ERROR);

}
	
@ResponseBody
@PostMapping("/deleteTodo")
public ResponseEntity<String> deleteToDo(@ModelAttribute ToDoBean toDoBean){
	try {
		int updatedTodo=  toDoUserDao.deleteToDoById(toDoBean.getId());
		if(updatedTodo>0) {
			return new ResponseEntity<String>("Successfully Updated ToDo", HttpStatus.OK);
		
	}} catch (Exception e) {
		e.printStackTrace();
	
	}
	return new ResponseEntity<String>("Failed to Update Todo", HttpStatus.INTERNAL_SERVER_ERROR);

}
	
	
}
