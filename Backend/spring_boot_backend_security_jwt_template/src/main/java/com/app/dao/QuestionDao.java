package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Question;
import com.app.entity.Quiz;

public interface QuestionDao extends JpaRepository<Question, Long> {

	List<Question> findByQuiz(Quiz quiz);
}
