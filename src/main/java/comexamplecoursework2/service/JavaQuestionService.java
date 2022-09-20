package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.example.RecurringQuestion;
import comexamplecoursework2.example.TheQuestionIsMissing;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private Random random = new Random();

    private Set<Question> questions = new HashSet<>(Set.of(
            new Question("Что делать?", "Мыслить"),
            new Question("Что делать?", "Шить"),
            new Question("Что делать?", "Мыть"),
            new Question("Что делать?", "Печь"),
            new Question("Что делать?", "Кодить"),
            new Question("Что делать?", "Плыть")
    ));

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new RecurringQuestion("Вопрос присутсвует в коллекции");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new TheQuestionIsMissing("Вопрос отсутсвет в коллекции");
        }
        return question;
    }

    @Override
    public Set<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
