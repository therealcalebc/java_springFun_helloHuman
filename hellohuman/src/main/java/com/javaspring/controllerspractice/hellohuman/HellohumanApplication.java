package com.javaspring.controllerspractice.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
	@RequestMapping("")
	public String index(@RequestParam(value="first_name", required=false) String firstName, @RequestParam(value="last_name", required=false) String lastName) {
		if(firstName == null && lastName == null)
			return "Hello Human!";
		else if(firstName == null)
			return String.format("Hello %s!", lastName);
		else if(lastName == null)
			return String.format("Hello %s!", firstName);
		else
			return String.format("Hello %s %s!", firstName, lastName);
	}

}
