package com.miniproject.todolist.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.todolist.beans.ToDoBean;
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
	  
	  public boolean checkIfUserAlreadyExist(String username) {
		  boolean isPresent =false;
		  jdbcTemplate = new JdbcTemplate(datasource);
		  String sql = "select count(*) from user_management.users where username = ?";
		  int count= jdbcTemplate.queryForObject(sql,new Object[] {username},Integer.class);
		  if(count>0) {
			  isPresent=true;
		  }
		  return isPresent;
		  
		  
	  }
	
	  public boolean checkIfEmailExist(String mailid) {
		  boolean isPresent = false;
		  jdbcTemplate = new JdbcTemplate(datasource);
		  String sql = "select count(*) from user_management.users where email= ?";
		  int count = jdbcTemplate.queryForObject(sql,new Object[] {mailid},Integer.class);
		  if(count>0) {
			  isPresent=true;
		  }
		  return isPresent;  	  
	  }


	public int registerUser(TodoUserBean todoUserBean) {
		jdbcTemplate = new JdbcTemplate(datasource);
		String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
		return jdbcTemplate.update(sql,new Object[] {todoUserBean.getUsername(),todoUserBean.getEmail(),todoUserBean.getPassword()});
	}
	
	
	public List<ToDoBean> getUserTodoFromId(String userId){
		jdbcTemplate = new JdbcTemplate(datasource);
		String sql = "select * from `user_management`.`todos` where user_id= ?";
		return jdbcTemplate.query(sql, new Object[] {userId}, new BeanPropertyRowMapper<>(ToDoBean.class));
		
	}


	public int saveToDo(ToDoBean todoBean) {
		jdbcTemplate = new JdbcTemplate(datasource);
		String  sql = "INSERT INTO todos (task, description, due_date, completed, user_id) "
				+ " VALUES "
				+ " (?, ?, ?, ?, ?);";
		return jdbcTemplate.update(sql,new Object[]{todoBean.getTask(),todoBean.getDescription(),todoBean.getDue_date(),false,todoBean.getUser_id()});
	}


	public int updateToDoById(ToDoBean toDoBean) {
		jdbcTemplate = new JdbcTemplate(datasource);
		String sql = "update user_management.todos set task= ?, description=? ,due_date=?, completed=?  where id = ? ";
		return jdbcTemplate.update(sql, new Object[] {toDoBean.getTask(),toDoBean.getDescription(),toDoBean.getDue_date(),toDoBean.getCompleted(),toDoBean.getId()});
	}


	public int deleteToDoById(String id) {
		jdbcTemplate = new JdbcTemplate(datasource);
		String sql = "delete from user_management.todos where id = ? ";
		return jdbcTemplate.update(sql, new Object[] {id});		
	}

}
