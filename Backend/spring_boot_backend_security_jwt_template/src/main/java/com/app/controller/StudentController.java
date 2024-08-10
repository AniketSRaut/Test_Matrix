package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDto;
import com.app.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studService;

	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody StudentDto stud) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studService.addStudent(stud));
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id){
		return ResponseEntity.ok(studService.getStudentById(id));
	}
}
