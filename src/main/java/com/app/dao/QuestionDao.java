package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.app.entity.Question;

public interface QuestionDao extends JpaRepository<Question, Long>{
	List<Question>findByCategory(String category);
	
//	List<Question> findRandomeQuestionByCategory(String category, int numQ);
	


}
