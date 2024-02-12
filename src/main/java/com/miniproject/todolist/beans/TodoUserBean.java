package com.miniproject.todolist.beans;

import java.io.Serializable;

public class TodoUserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_id;
	private String username ;
	private String email;
	private String password;	
	private String message ;
	private String errorMessage;
	
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPassword() {
	return password;
	
}
public void setPassword(String password) {
	this.password = password;
}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "TodoUserBean [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password="
				+ password + "]";
	}
	
	

}
