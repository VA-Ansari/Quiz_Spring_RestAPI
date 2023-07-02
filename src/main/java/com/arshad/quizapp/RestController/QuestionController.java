package com.arshad.quizapp.RestController;

import com.arshad.quizapp.Entity.Question;
import com.arshad.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("getallquestion")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<Question> getAllQuestionByCategory(@PathVariable String category){
        return questionService.getAllQuestionByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }
}
