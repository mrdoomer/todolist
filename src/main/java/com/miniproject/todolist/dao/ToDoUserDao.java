package com.miniproject.todolist.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.todolist.beans.TodoUserBean;

@Repository
public class ToDoUserDao {
	
	  
	  @Autowired DataSource datasource ;
	  
	  @Autowired JdbcTemplate jdbcTemplate;
	  
	  
	  
	  public TodoUserBean getUserDataById(Long userId) {
		  jdbcTemplate = new JdbcTemplate(datasource);
		  String sql = "select * from user_management.users where user_id = ?";
		  TodoUserBean user = (TodoUserBean)jdbcTemplate.queryForObject(sql, new Object[] {userId}, new BeanPropertyRowMapper<>(TodoUserBean.class));
		  return user  ;
	  }
	 
	  
	  public TodoUserBean getUserByUsername(String username) {
		  jdbcTemplate = new JdbcTemplate(datasource);
		  String sql = "select * from user_management.users where username = ?";
		  TodoUserBean user = (TodoUserBean)jdbcTemplate.queryForObject(sql, new Object[] {username}, new BeanPropertyRowMapper<>(TodoUserBean.class));
		  System.out.println(user);
		  return user  ;
		  
	  }

}
