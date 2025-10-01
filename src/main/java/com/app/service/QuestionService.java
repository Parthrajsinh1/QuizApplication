package com.app.service;

import java.util.List;

import com.app.entity.Question;

public interface QuestionService {
	public List<Question> getAllQuestions();

	public List<Question> getQuestionsByCategory(String category);

	public String addQuestion(Question question);

	public String deleteQuestionById(Long id);

	public String updateQuestion(Question question);
}
