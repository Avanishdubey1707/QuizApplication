package com.putin.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.putin.quizapp.Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
