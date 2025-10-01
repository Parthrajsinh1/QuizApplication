package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entity.Question;
import com.app.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService queService;
	
	//add REST to get all question
	
	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions(){
		return queService.getAllQuestions();
	}
	
	//add REST to get all question from specific category
	@GetMapping("/category/{category}") //pathvariable
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		return queService.getQuestionsByCategory(category);
	}
	
	//add REST to add Question 
	@PostMapping("/addQuestion")
	public ResponseEntity<?> addQuestion(@RequestBody Question question) {
		try {
		return new ResponseEntity<>(queService.addQuestion(question), HttpStatus.CREATED);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//add REST to update Question
	@PutMapping
	public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
		try {
		return new ResponseEntity<>(queService.updateQuestion(question), HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//add REST to delete question by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteQuestionById(@PathVariable Long id) {
		try {
			//return new ResponseEntity<>(queService.deleteQuestionById(id), HttpStatus.OK);  //way-1
			return ResponseEntity.ok(new ApiResponse( queService.deleteQuestionById(id))); 						//way-2
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
