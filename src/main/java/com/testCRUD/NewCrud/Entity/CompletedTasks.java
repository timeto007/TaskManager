package com.testCRUD.NewCrud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CompletedTasks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int compTaskId;
	private String compTask;
	private String createdTime;
	private String compTime;
	
	
	public CompletedTasks(String compTask, String createdTime, String compTime) {
		super();
		this.compTask = compTask;
		this.createdTime = createdTime;
		this.compTime = compTime;
	}
	
	
	public CompletedTasks() {
		super();
	}


	public String getCompTask() {
		return compTask;
	}
	public void setCompTask(String compTask) {
		this.compTask = compTask;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getCompTime() {
		return compTime;
	}
	public void setCompTime(String compTime) {
		this.compTime = compTime;
	}
	
}
