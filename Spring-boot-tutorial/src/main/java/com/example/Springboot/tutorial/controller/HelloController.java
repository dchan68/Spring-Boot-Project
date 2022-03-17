package com.example.Springboot.tutorial.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //This is a component and a type of controller
public class HelloController {
	
	@GetMapping //This will do the same thing @RequestMapping(value ="/", method = RequestMethod.GET)
	public String helloworld() {
		return "WElCOME";
	}
}
