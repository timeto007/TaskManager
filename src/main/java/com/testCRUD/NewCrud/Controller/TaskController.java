package com.testCRUD.NewCrud.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testCRUD.NewCrud.Entity.CompletedTasks;
import com.testCRUD.NewCrud.Entity.Tasks;
import com.testCRUD.NewCrud.Service.TaskService;

@RestController
@RequestMapping(path="task")
public class TaskController {
	
	
	
	public final  TaskService taskService;
	

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}





	@PostMapping
	public String createTask(@RequestBody Tasks task) {
		System.out.println("controller");
		return this.taskService.createTask(task);
		 
	}
	
	@GetMapping
	public List<Tasks> nonCompltedTask(){
		return this.taskService.nonCompletedTasks();
	}
	
	@PutMapping(path="{taskId}")
	public String completTask(
			@PathVariable("taskId") Long taskId) {
		return  this.taskService.completeTask(taskId);
	}
	
	
	@RequestMapping(path="completed")
	@GetMapping()
	public List<CompletedTasks> fullCompTasks() {
		return this.taskService.fullCompTask();
	}
	
	
	@PutMapping("edit/{taskId}")
	public String editTask(@PathVariable("taskId") Long taskId,@RequestParam(required = false) String task) {
		return this.taskService.editTask(taskId,task);
	}
	
	
	////delete-------http://localhost:2255/task/delete/1
	@DeleteMapping("delete/{taskId}")
	public String deleteTask(@PathVariable("taskId") Long taskId) {
		return this.taskService.deleteTask(taskId);
	}
	
	
}
