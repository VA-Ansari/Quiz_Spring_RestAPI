package com.arshad.quizapp.Service;

import com.arshad.quizapp.Entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {

    List<Question> getAllQuestion();

    List<Question> getAllQuestionByCategory(String category);

    String addQuestion(Question question);
}
