package com.example.assessmentservice.service;

import com.example.assessmentservice.entity.Quiz;
import java.util.List;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);
    List<Quiz> getAllQuizzes();
    Quiz getQuizById(Long id);
    Quiz updateQuiz(Long id, Quiz quiz);
    void deleteQuiz(Long id);
}
