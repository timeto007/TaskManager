package com.testCRUD.NewCrud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tasks")
public class Tasks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int taskId;
	private String task;
	private String date;
	
	
	

	
	
	@Override
	public String toString() {
		return "Tasks [task=" + task + ", date=" + date + "]";
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String now) {
		this.date = now;
	}
	public Tasks(int taskId, String task) {
		super();
		this.taskId = taskId;
		this.task = task;
		
	}
	public Tasks() {
		super();
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public Tasks(int taskId, String task, String date) {
		super();
		this.taskId = taskId;
		this.task = task;
		this.date = date;
	}
	
	
	
}
