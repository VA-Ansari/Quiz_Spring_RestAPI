package com.arshad.quizapp.Service;

import com.arshad.quizapp.Entity.QuestionWrapper;
import com.arshad.quizapp.Entity.Quiz;
import com.arshad.quizapp.Entity.Response;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(String category, Integer numq, String title);

    List<QuestionWrapper> getQuiz(Integer id);

    int calculateResult(Integer id, List<Response> response);
}
