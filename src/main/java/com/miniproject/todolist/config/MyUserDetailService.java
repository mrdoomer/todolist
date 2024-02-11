package com.miniproject.todolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miniproject.todolist.beans.TodoUserBean;
import com.miniproject.todolist.dao.ToDoUserDao;
@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private ToDoUserDao toDoUserDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TodoUserBean user = toDoUserDao.getUserByUsername(username);
		if (user==null )
			throw new UsernameNotFoundException("User 404 ");
		 
		return new UserPrinciple(user);
	}

}
