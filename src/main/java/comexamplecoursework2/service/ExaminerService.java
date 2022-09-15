package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
