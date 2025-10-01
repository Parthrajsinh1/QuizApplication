package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.entity.Response;

public interface QuizService {

	ResponseEntity<?> createQuiz(String category, int numQ, String title);

	ResponseEntity<?> getQuizQuestions(Long id);

	ResponseEntity<?> calculateResult(Long id, List<Response> responses);

}
