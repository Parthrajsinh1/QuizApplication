package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Response;
import com.app.service.QuizService;



@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createQuiz(@RequestParam String category , @RequestParam int numQ , @RequestParam String title){
		return quizService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getQuizQuestions(@PathVariable Long id){
		
	return	quizService.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<?> submitQuiz(@PathVariable Long id , @RequestBody List<Response> responses){
		return quizService.calculateResult(id,responses);
	}
}
