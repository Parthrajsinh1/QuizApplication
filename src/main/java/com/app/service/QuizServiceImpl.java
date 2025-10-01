package com.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dao.QuestionDao;
import com.app.dao.QuizDao;
import com.app.entity.Question;
import com.app.entity.QuestionWrapper;
import com.app.entity.Quiz;
import com.app.entity.Response;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    @Override
    public ResponseEntity<?> createQuiz(String category, int numQ, String title) {
        Quiz quiz = new Quiz();
        quiz.setTitle(title);

        // 1. Get all questions for the category
        List<Question> allQuestions = questionDao.findByCategory(category);

        // 2. Shuffle to randomize
        Collections.shuffle(allQuestions);

        // 3. Pick only numQ questions
        List<Question> selectedQuestions;
        if (allQuestions.size() > numQ) {
            selectedQuestions = allQuestions.subList(0, numQ);
        } else {
            selectedQuestions = allQuestions;
        }

        // 4. Set questions to quiz
        quiz.setQuestions(selectedQuestions);

        // 5. Save the quiz (optional, if you want to persist)
        quizDao.save(quiz);

        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

	@Override
	public ResponseEntity<?> getQuizQuestions(Long id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		for(Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> calculateResult(Long id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i = 0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) 
				right++;
			
			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
    
	
    
}
