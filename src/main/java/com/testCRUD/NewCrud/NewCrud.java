package com.testCRUD.NewCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.testCRUD.NewCrud.imageRepo"})
public class NewCrud {

	public static void main(String[] args) {
		SpringApplication.run(NewCrud.class, args);
		
		
	}

}



//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-jpa</artifactId>
//</dependency>
