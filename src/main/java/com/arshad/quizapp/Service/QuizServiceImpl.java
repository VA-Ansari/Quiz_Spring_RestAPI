package com.arshad.quizapp.Service;

import com.arshad.quizapp.Entity.Question;
import com.arshad.quizapp.Entity.QuestionWrapper;
import com.arshad.quizapp.Entity.Quiz;
import com.arshad.quizapp.Entity.Response;
import com.arshad.quizapp.Repository.QuestionRepository;
import com.arshad.quizapp.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Quiz createQuiz(String category, Integer numq, String title) {
        Quiz quiz = new Quiz();
        quiz.setTitle(title);

        List<Question> qns = questionRepository.findRandomQuestionsByCategory(category, numq);
        quiz.setQuestion(qns);

        return quizRepository.save(quiz);
    }

    @Override
    public List<QuestionWrapper> getQuiz(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestion();

        List<QuestionWrapper> questionsToUser = new ArrayList<>();

        //filling the fetched questions in questionWrapper(only data which we want to show)
        for (Question q : questionsFromDB){
            QuestionWrapper questionWrapper = new QuestionWrapper(
                    q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),
                    q.getOption3(), q.getOption4()
            );
            questionsToUser.add(questionWrapper);
        }

        return questionsToUser;
    }

    @Override
    public int calculateResult(Integer id, List<Response> response) {
        Optional<Quiz> quiz = Optional.of(quizRepository.findById(id).get());

        List<Question> questions = quiz.get().getQuestion();

        //comparing values in the response and in the response
        int right  = 0;
        int i = 0;
        for (Response res: response){
            if (res.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }

        return right;
    }
}
