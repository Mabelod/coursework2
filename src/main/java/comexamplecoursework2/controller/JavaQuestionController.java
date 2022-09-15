package comexamplecoursework2.controller;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String QuestionText, @RequestParam("answer") String QuestionAnswer) {
        return questionService.add(questionService.add(QuestionText, QuestionAnswer));
    }

    @GetMapping()
    public List<Question> getQuestion() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String QuestionText, @RequestParam("answer") String QuestionAnswer) {
        return questionService.remove(questionService.add(QuestionText, QuestionAnswer));
    }
}
