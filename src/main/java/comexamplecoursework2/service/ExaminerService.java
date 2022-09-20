package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
