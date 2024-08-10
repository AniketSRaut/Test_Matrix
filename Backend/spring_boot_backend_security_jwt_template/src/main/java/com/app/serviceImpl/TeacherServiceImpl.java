package com.app.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SubjectDao;
import com.app.dao.TeacherDao;
import com.app.dto.TeacherDto;
import com.app.entity.Subject;
import com.app.entity.Teacher;
import com.app.service.TeacherService;

@Transactional
@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	SubjectDao subjecDao;
	
	@Autowired
	ModelMapper mapper;
	
	
	@Override
	public String addTeacher(TeacherDto teacher) {
		
		Teacher t = mapper.map(teacher, Teacher.class);
		
		Set<Subject> subjects = new HashSet<>();
        for (Long subjectId : teacher.getSubjectId()) {
        	Subject sub = subjecDao.findById(subjectId).orElseThrow();
        	subjects.add(sub);
        }
       //t.setAddress(teacher.getAddress());
       t.setSubjects(subjects);
       
       
       teacherDao.save(t);
        return "Teacher added Successfully.";
       
       
		
	}

}
