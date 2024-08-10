package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ReqResultDto;
import com.app.serviceImpl.ResultServiceImpl;

@RestController
@RequestMapping("/result")
public class ResultController {

	@Autowired
	ResultServiceImpl resultService;
	
	@PostMapping("/generate")
	public ResponseEntity<?> addResult(@RequestBody @Valid  ReqResultDto resultDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(resultService.generateResult(resultDto));
	}
}
