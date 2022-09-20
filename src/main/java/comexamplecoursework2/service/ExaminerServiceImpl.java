package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.example.LargeNumberOfQuestions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new LargeNumberOfQuestions("Превышена длинна массива");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
            }
        return questions;
    }
}
