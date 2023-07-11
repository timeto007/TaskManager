package com.testCRUD.NewCrud.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	//Upload Image
	@PostMapping("fileUpload")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException{
		String uploadImage=taskService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}
	
	
	//downloadimage
	@GetMapping("{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] image=taskService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(image);
	}
		
	
}
