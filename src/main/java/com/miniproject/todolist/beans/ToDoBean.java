package com.miniproject.todolist.beans;

import java.io.Serializable;

public class ToDoBean implements Serializable{
	private String id;
	private String user_id;
	private String task;
	private String description ;
	private String due_date;
	private String completed ;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "ToDoBean [id=" + id + ", user_id=" + user_id + ", task=" + task + ", description=" + description
				+ ", due_date=" + due_date + ", completed=" + completed + "]";
	}
	

}
