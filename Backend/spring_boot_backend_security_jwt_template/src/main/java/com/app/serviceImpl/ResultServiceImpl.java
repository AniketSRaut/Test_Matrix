package com.app.serviceImpl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.QuestionDao;
import com.app.dao.QuizDao;
import com.app.dao.ResultDao;
import com.app.dto.ReqResultDto;
import com.app.dto.ResQuestionDto;
import com.app.dto.ResResultDto;
import com.app.entity.Quiz;
import com.app.entity.Result;
import com.app.entity.StudQuizId;
import com.app.service.ResultService;

@Service
@Transactional
public class ResultServiceImpl implements ResultService {

	@Autowired
	ResultDao resultDao;

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionServiceImpl questionService;


	@Autowired
	ModelMapper model;
	
	@Override
	public ResResultDto generateResult(ReqResultDto resultDto) {
		StudQuizId sqid=resultDto.getSqId();
		Result result=model.map(resultDto,Result.class);
		Quiz quiz=quizDao.findById(sqid.getQuizId())
				.orElseThrow(()->new ResourceNotFoundException("Quiz id not found!"));
		Map<Long,Integer> markedOptions=resultDto.getMarkedOptions();
		List<ResQuestionDto> questionList=questionService.getQuestionList(quiz.getId());
		for(ResQuestionDto question:questionList) {
			if(markedOptions.get(question.getId())== question.getCorrectAns()) {
				result.setObtainedMarks(result.getObtainedMarks()+1);
			}	
		}
		resultDao.save(result);
		return model.map(result, ResResultDto.class);
	}
}
