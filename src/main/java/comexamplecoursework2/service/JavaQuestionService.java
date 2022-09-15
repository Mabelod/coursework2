package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.example.RecurringQuestion;
import comexamplecoursework2.example.TheQuestionIsMissing;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService{

    private List<Question> questions = new ArrayList<>(List.of(
            new Question("Что делать?", "Мыслить"),
            new Question("Что делать?", "Шить"),
            new Question("Что делать?", "Мыть"),
            new Question("Что делать?", "Печь"),
            new Question("Что делать?", "Кодить"),
            new Question("Что делать?", "Плыть")
    ));

    @Override
    public Question add(String question, String answer) {
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new RecurringQuestion("Вопрос присутсвует в коллекции");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new TheQuestionIsMissing("Вопрос отсутсвет в коллекции");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public List<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int number = random.nextInt(0, questions.size());
        return questions.get(number);
    }
}
