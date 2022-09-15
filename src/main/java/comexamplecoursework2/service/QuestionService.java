package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;

import java.util.List;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    List<Question> getAll();

    Question getRandomQuestion();
}
