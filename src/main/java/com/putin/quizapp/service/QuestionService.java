package com.putin.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.putin.quizapp.Model.Question;
import com.putin.quizapp.dao.QuestionDao;



@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getALLquestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
		     return new ResponseEntity<>( questionDao.findByCategory(category),HttpStatus.OK);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("succes",HttpStatus.CREATED);
		// TODO Auto-generated method stub
		
	}

}
