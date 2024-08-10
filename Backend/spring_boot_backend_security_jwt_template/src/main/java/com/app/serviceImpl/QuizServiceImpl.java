package com.app.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.BatchDao;
import com.app.dao.QuizDao;
import com.app.dao.SubjectDao;
import com.app.dto.ApiResponse;
import com.app.dto.ResReqQuizDto;
//import com.app.dto.SubjectDto;
import com.app.entity.Batch;
import com.app.entity.Quiz;
import com.app.entity.Subject;
import com.app.service.QuizService;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {
	@Autowired
	QuizDao quizdao;
	
	@Autowired
	BatchDao batchdao;
	
	@Autowired
	SubjectDao subjectdao;
	
	@Autowired
	ModelMapper model;
	

	@Override
	public ApiResponse addQuiz(ResReqQuizDto quizdto) {
		Long batchId[] = quizdto.getBatchId();
		
		 Quiz quiz = model.map(quizdto,Quiz.class);
		 Subject subject = subjectdao.findById(quizdto.getSubjectId())
				 .orElseThrow(() -> new ResourceNotFoundException("Batch of given Id not found!"));
		 quiz.setSubject(subject);
		 
		 for(Long batchid : batchId) {
			 Batch batch = batchdao.findById(batchid)
						.orElseThrow(() -> new ResourceNotFoundException("Batch of given Id not found!"));
//			 quiz.addBatch(batch);
			 quiz.getBatch().add(batch);
		 }
		 quizdao.save(quiz);	 
		
		return new ApiResponse("Quiz added successfully");
	}

	@Override
	public ApiResponse editQuiz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> getAllQuiz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> getScheduledQuiz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> getCompletedQuiz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse scheduleQuiz() {
		// TODO Auto-generated method stub
		return null;
	}

}
