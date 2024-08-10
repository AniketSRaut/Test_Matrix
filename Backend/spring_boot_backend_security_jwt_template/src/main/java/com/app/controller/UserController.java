package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginInputDto;
import com.app.dto.LoginOutPutDto;
import com.app.service.UserService;

import lombok.Getter;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginInputDto input){
		LoginOutPutDto out= userService.loginUser(input);
		
		if(out != null) {
			return ResponseEntity.ok(out);
		}
		return ResponseEntity.badRequest().body("Invalid Credential ..");
		
		
		 
	}
	

}
