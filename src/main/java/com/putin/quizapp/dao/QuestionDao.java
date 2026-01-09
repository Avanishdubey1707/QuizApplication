package com.putin.quizapp.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.putin.quizapp.Model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(
        value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND()",
        nativeQuery = true
    )
    List<Question> findRandomQuestionByCategory(
            @org.springframework.data.repository.query.Param("category") String category,
            org.springframework.data.domain.Pageable pageable
    );
}
