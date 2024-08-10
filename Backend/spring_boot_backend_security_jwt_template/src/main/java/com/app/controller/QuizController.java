package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResReqQuizDto;
import com.app.serviceImpl.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizServiceImpl quizService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBatch(@RequestBody @Valid  ResReqQuizDto quizDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(quizService.addQuiz(quizDto));
	}
}
