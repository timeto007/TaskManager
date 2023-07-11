package com.testCRUD.NewCrud.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.testCRUD.NewCrud.Entity.CompTaskRepo;
import com.testCRUD.NewCrud.Entity.CompletedTasks;
import com.testCRUD.NewCrud.Entity.TaskRepository;
import com.testCRUD.NewCrud.Entity.Tasks;

import fileCompress.ImageCompress;
import imageEntity.ImageEntity;
import imageRepo.ImageRepository;
import jakarta.transaction.Transactional;


@Service
public class TaskService {
	@Autowired
	public  TaskRepository taskRepo;
	@Autowired
	public  CompTaskRepo compTaskRepo;
	@Autowired
	public ImageRepository imageRepo;
	
//	public TaskService(CompTaskRepo compTaskRepo) {
//		super();
//		this.compTaskRepo = compTaskRepo;
//	}
	
//	public TaskService(TaskRepository taskRepo) {
//		super();
//		this.taskRepo = taskRepo;
//	}

	//POST request-----http://localhost:2255/task
	public String createTask(Tasks task) {
		DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		String date=formater.format(now);
		task.setDate(date);
		this.taskRepo.save(task);
		return task.getTask()+" Added at : "+task.getDate();
		
	}
	
	
	//GET Request-----http://localhost:2255/task

	public List<Tasks> nonCompletedTasks(){
		return this.taskRepo.findAll();
	}
	
	
	//GET -------http://localhost:2255/task/completed
	public List<CompletedTasks> compTask() {
		return this.compTaskRepo.findAll();
	}
	
	
	////this for complete the task---PUT-----http://localhost:2255/task/2
	@Transactional
	public String completeTask(Long taskId) {
		Tasks comptask=taskRepo.findById(taskId).orElseThrow(()->new IllegalThreadStateException(taskId+" task not found"));
		
		
		DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		String date=formater.format(now);
		
		CompletedTasks comp=new CompletedTasks(comptask.getTask(),comptask.getDate(),date);
		this.compTaskRepo.save(comp);
		this.taskRepo.deleteById(taskId);
		return "completed the task "+comp.getCompTask();
		

	}
	
	//Completed task---GET---http://localhost:2255/task/completed
	public List<CompletedTasks> fullCompTask(){
		return this.compTaskRepo.findAll();
	}
	
	
	///Edit ----PUT----http://localhost:2255/task/edit/1?task=nothing
	public String editTask(Long taskId,String task) {
		Tasks t=taskRepo.findById(taskId).orElseThrow(()->new IllegalThreadStateException("task not found"));
		
		DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		String date=formater.format(now);
		
		t.setTask(task);
		t.setDate(date);
		this.taskRepo.save(t);
		return "Edited the task "+task;
	}


	public String deleteTask(Long taskId) {
		this.taskRepo.deleteById(taskId);
		return "deleted the task";
	}
	
	////file upload
	public String uploadImage(MultipartFile file) throws IOException {
		ImageEntity image= imageRepo.save(ImageEntity.builder()
				.Name(file.getOriginalFilename())
				.type(file.getContentType())
				.imageData(ImageCompress.compressImage(file.getBytes())).build());
		if(image!=null) return "file uploded successfully "+ file.getOriginalFilename();
		
		return null;
	}
	
	
	//download image
	public byte[] downloadImage(String fileName) {
		Optional<ImageEntity> dbImage= imageRepo.findByName(fileName);
		return ImageCompress.decompressImage(dbImage.get().getImageData());
	}
	
	
}
