package com.putin.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.putin.quizapp.Model.Question;
import com.putin.quizapp.Model.QuestionWrapper;
import com.putin.quizapp.Model.Quiz;
import com.putin.quizapp.dao.QuestionDao;
import com.putin.quizapp.dao.QuizDao;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        Pageable pageable = PageRequest.of(0, numQ);

        List<Question> questions =
                questionDao.findRandomQuestionByCategory(category, pageable);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return ResponseEntity.ok("Quiz created successfully");
        
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser =  new ArrayList<>();
        for(Question q: questionsFromDB){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(), q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);


        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }
}
