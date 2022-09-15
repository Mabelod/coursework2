package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.example.LargeNumberOfQuestions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new LargeNumberOfQuestions("Превышена длинна массива");
        }
        List<Question> questions = new ArrayList<>();
        questions.add(questionService.getRandomQuestion());
        int counter = 0;
        while (amount - 1 > counter) {
            Question question = questionService.getRandomQuestion();
            if (!questions.contains(question)) {
                questions.add(question);
                counter++;
            }
        }
        return questions;
    }
}
