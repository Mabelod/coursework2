package comexamplecoursework2.controller;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("questionText") String questionText, @RequestParam("questionAnswer") String questionAnswer) {
        return questionService.add(questionText, questionAnswer);
    }

    @GetMapping()
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("questionText") String questionText, @RequestParam("questionAnswer") String questionAnswer) {
        return questionService.remove(new Question(questionText, questionAnswer));
    }
}
