package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ResReqQuizDto;
import com.app.entity.Quiz;

public interface QuizService {
	
	ApiResponse addQuiz(ResReqQuizDto quizdto);
	ApiResponse editQuiz();
	ApiResponse deleteQuiz(Long quizId);
	List<Quiz> getAllQuiz();
	List<Quiz> getScheduledQuiz();
	List<Quiz> getCompletedQuiz();
	ApiResponse scheduleQuiz();
}
