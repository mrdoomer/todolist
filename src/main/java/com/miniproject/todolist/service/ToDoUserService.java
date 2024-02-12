package com.miniproject.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.miniproject.todolist.beans.TodoUserBean;
import com.miniproject.todolist.dao.ToDoUserDao;

@Service
public class ToDoUserService {

	@Autowired
	ToDoUserDao todoUserDao;

	public TodoUserBean getUserDetailFromId(Long userId) {
		TodoUserBean user = new TodoUserBean();
		try {

			user = todoUserDao.getUserDataById(userId);
		} catch (IncorrectResultSizeDataAccessException ex) {
			user.setErrorMessage("No User Found");

		} catch (Exception e) {
			user.setErrorMessage("Error In Getting userData From id");
		}

		return user;

	}

	public TodoUserBean getUserDetailFromUsername(String username) {
		TodoUserBean user = new TodoUserBean();
		try {
			user = todoUserDao.getUserByUsername(username);

		} catch (Exception e) {
			user.setErrorMessage("Error getting Username In " + e);
		}
		return user;
	}
	
	
	
	public int saveUser(TodoUserBean todoUserBean) throws Exception{
		int userInserted = 0 ;
		try {
		userInserted = todoUserDao.registerUser(todoUserBean);
		
		} catch (Exception e) {
			throw new Exception("Error while saving user "+e);
		}
		return userInserted ;
		
		
	}
	
	
	

}
