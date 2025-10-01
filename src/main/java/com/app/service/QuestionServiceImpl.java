package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.QuestionDao;
import com.app.dto.ApiResponse;
import com.app.entity.Question;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao queDao;
	
	@Override
	public List<Question> getAllQuestions() {
		return queDao.findAll();
	}

	@Override
	public List<Question> getQuestionsByCategory(String category) {
		return queDao.findByCategory(category);
	}

	@Override
	public String addQuestion(Question question) {
		queDao.save(question) ;
		return "success";
	}

	@Override
	public String deleteQuestionById(Long id) {
		if(queDao.existsById(id)) {
		queDao.deleteById(id);
		return "Delete success";
		}else {
			return "Invalid Id !!";
		}
	}

	@Override
	public String updateQuestion(Question question) {
		if(queDao.existsById(question.getId())) {
			queDao.save(question);
			return "Update success";
		}else {
			return"Inavlid ID !!";
		}
		
	}

	

	

}
