package com.arshad.quizapp.Repository;

import com.arshad.quizapp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    //the data jpa will help us to a point only, and the after we ourselves have to write the query
    // annotation will take two parameters 1. Query and 2. native

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numq", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, Integer numq);
}
