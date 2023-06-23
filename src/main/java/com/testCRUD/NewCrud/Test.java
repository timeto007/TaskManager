package com.testCRUD.NewCrud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Test {
	
	@GetMapping("/")
	public String helloWorld() {
		return "hellottoddoso";
	}
}
