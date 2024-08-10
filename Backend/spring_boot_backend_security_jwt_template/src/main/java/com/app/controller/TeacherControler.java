package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TeacherDto;
import com.app.service.TeacherService;


@RestController
@RequestMapping("/teacher")
public class TeacherControler {

	@Autowired
	TeacherService teacherServie;
	
	@PostMapping("/add")
	public ResponseEntity<?> addTecher(@RequestBody TeacherDto teacherDto){
		return ResponseEntity.ok(teacherServie.addTeacher(teacherDto));
	}
}
