package com.arshad.quizapp.RestController;

import com.arshad.quizapp.Entity.QuestionWrapper;
import com.arshad.quizapp.Entity.Quiz;
import com.arshad.quizapp.Entity.Response;
import com.arshad.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("create")
    public Quiz createQuiz(@RequestParam String category, @RequestParam Integer numq, @RequestParam String title){
//        return "HELLO "+ category +" " + numq +" " + title;
        return quizService.createQuiz(category, numq, title);
    }

    @GetMapping("get/{id}")
    public List<QuestionWrapper> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }

    @GetMapping("submit/{id}")
    public int submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
        return quizService.calculateResult(id, response);
    }
}
