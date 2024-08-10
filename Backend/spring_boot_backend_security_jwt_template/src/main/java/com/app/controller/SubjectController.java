package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Event;
import com.app.entity.Subject;
import com.app.service.SubjectService;

@RestController
@RequestMapping("/subject")

public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@GetMapping("/getAllSubject")
	public ResponseEntity<?> getAllSubject(){
		
		return ResponseEntity.ok(subjectService.getAllSubjects());
		
	}
	
	
	@PostMapping("/addSubject")
	public ResponseEntity<?> addSubject(@RequestBody Subject subject){
		try {
			String str = subjectService.addSubject(subject);
			return ResponseEntity.status(HttpStatus.CREATED).body(str);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Subject not added");
		}
	}

}
