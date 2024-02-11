package com.miniproject.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.todolist.beans.TodoUserBean;
import com.miniproject.todolist.dao.ToDoUserDao;

@Service
public class ToDoUserService {
	
	  @Autowired ToDoUserDao todoUserDao;
	  
	  public TodoUserBean getUserDetailFromId(Long userId) {
	  
	  TodoUserBean user = todoUserDao.getUserDataById(userId);
	  
	  return user; 
	 
	  }
	  

	  public TodoUserBean getUserDetailFromUsername(String username) {
	  
	  TodoUserBean user = todoUserDao.getUserByUsername(username);
	  
	  return user; }
	 


}
