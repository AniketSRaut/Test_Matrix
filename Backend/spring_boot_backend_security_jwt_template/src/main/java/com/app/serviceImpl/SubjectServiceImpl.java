package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SubjectDao;
import com.app.dto.ApiResponse;
import com.app.entity.Subject;
import com.app.service.SubjectService;

@Transactional
@Service

public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;

	@Override
	public List<Subject> getAllSubjects() {
		
		return subjectDao.findAll();
	}

	@Override
	public String addSubject(Subject subject) {
		if(subjectDao.save(subject)!=null)
		{
			return "Subject added successfully!";
		}
		
		return "Subject not added";
		
	}

	@Override
	public ApiResponse deleteSubject(Long id) {
		
		subjectDao.
		
		
		return ;
	}
	
}
