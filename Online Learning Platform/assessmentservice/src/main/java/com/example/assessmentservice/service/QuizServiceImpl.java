package com.example.assessmentservice.service;

import com.example.assessmentservice.entity.Quiz;
import com.example.assessmentservice.exception.ResourceNotFoundException;
import com.example.assessmentservice.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
    }

    @Override
    public Quiz updateQuiz(Long id, Quiz quiz) {
        Quiz existing = getQuizById(id);
        existing.setTitle(quiz.getTitle());
        existing.setDescription(quiz.getDescription());
        existing.setQuestions(quiz.getQuestions());
        existing.setTotalMarks(quiz.getTotalMarks());
        return quizRepository.save(existing);
    }

    @Override
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
