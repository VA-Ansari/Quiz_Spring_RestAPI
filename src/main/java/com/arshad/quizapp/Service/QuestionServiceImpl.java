package com.arshad.quizapp.Service;

import com.arshad.quizapp.Entity.Question;
import com.arshad.quizapp.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    @Override
    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Success";
    }
}
