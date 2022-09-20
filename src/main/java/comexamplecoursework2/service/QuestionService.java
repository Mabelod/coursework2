package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Set<Question> getAll();

    Question getRandomQuestion();
}
