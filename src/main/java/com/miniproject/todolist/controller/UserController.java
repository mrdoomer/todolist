package com.miniproject.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.todolist.beans.TodoUserBean;
import com.miniproject.todolist.service.ToDoUserService;


@RestController
public class UserController {
	
	@Autowired
	ToDoUserService todoUserService;

	@GetMapping("/getUsername/{userId}")
	public ResponseEntity<TodoUserBean> getMethodName(@PathVariable Long userId) {
		TodoUserBean user = todoUserService.getUserDetailFromId(userId);	
			if (user==null) {
				ResponseEntity.notFound().build();
			}
			
		return ResponseEntity.ok(user);
	}
	

	@GetMapping("/getFromUsername/{username}")
	public ResponseEntity<TodoUserBean> getMethodName(@PathVariable String username) {
		TodoUserBean user = new TodoUserBean();
		try {
			user = todoUserService.getUserDetailFromUsername(username);	
			if (user==null) {
				ResponseEntity.notFound().build();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(user);
	}
	
	
}
