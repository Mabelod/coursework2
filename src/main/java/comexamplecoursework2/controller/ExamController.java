package comexamplecoursework2.controller;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/randomQuestion")
    public List<Question> getQuestions(@RequestParam("number") int amount) {
        return examinerService.getQuestions(amount);
    }
}
