package com.miniproject.todolist.beans;

public class TodoUserBean {
	
	private String user_id;
	private String username ;
	private String email;
private String password;	
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