package com.app.service;

import com.app.dto.StudentDto;
import com.app.dto.StudentOutputDto;
import com.app.entity.Student;

public interface StudentService {

	public Student addStudent(StudentDto stud);
	
	public StudentOutputDto getStudentById(Long id);
}
