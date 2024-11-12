package com.vsr.demo.on.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsr.demo.on.hibernate.service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService ser;
	
	@GetMapping("/use")
	public String getData() {
		ser.excute();
		return "Created";
	}

}
