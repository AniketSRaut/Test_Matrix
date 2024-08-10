package com.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.BatchDao;
import com.app.dao.StudentDao;
import com.app.dto.ApiResponse;
import com.app.dto.StudentDto;
import com.app.dto.StudentOutputDto;
import com.app.entity.Batch;
import com.app.entity.Student;
import com.app.service.StudentService;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	BatchDao batchDao ;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public Student addStudent(StudentDto studDto) {
		
			Student  stud = mapper.map(studDto,Student.class);
			
			Batch batch = batchDao.findById(studDto.getBatchId()).orElseThrow(()-> new ResourceNotFoundException("Batch not exist"));
			
			stud.setBatch(batch);
			batch.getStudentList().add(stud);
			//		 Holiday holiday = modelMapper.map(holidayDTO, Holiday.class);
		System.out.println(stud.toString());
			return studentDao.save(stud);
		
	}

	@Override
	public StudentOutputDto getStudentById(Long id) {
		
		Student stud = studentDao.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
		
		
		
		return mapper.map(stud,StudentOutputDto.class );
		
	}

}
