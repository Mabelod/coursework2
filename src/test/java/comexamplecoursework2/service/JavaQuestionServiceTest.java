package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.example.RecurringQuestion;
import comexamplecoursework2.example.TheQuestionIsMissing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @AfterEach
    public void afterEach() {
        Collection <Question> questions = questionService.getAll();
        questions.forEach(questionService::remove);
    }

    @ParameterizedTest
    @MethodSource("params")
    void add(String question, String answer) {
        int size = questionService.getAll().size();
        assertThat(questionService.getAll()).isNotEmpty(); // проверка на длинну коллекции
        Question expected = new Question(question, answer);
        questionService.add(expected);
        assertThat(questionService.getAll())
                .contains(expected); // проверка на присутствие вопроса в коллекции
        assertThat(questionService.getAll()).hasSize(size + 1);

    }

    @Test
    void addNegative() {
        assertThat(questionService.getAll()).isNotEmpty(); // проверка на длинну коллекции
        Question expected = new Question("Что делать?", "Мыслить");
        assertThatExceptionOfType(RecurringQuestion.class)
                .isThrownBy(() -> questionService.add(expected));
        assertThatExceptionOfType(RecurringQuestion.class)
                .isThrownBy(() -> questionService.add(expected.getQuestion(), expected.getAnswer()));

    }

    @ParameterizedTest
    @MethodSource("questions")
    void remove(Question question) {
        assertThat(questionService.getAll()).isNotEmpty();
        Question expected = question;
        questionService.add(expected);
        assertThat(questionService.remove(expected)).isEqualTo(question);
        assertThatExceptionOfType(TheQuestionIsMissing.class).isThrownBy(() -> questionService.remove(expected));
    }

    @Test
    void getRandomQuestion() {
        assertThat(questionService.getAll()).isNotEmpty();
        int size = questionService.getAll().size() + 5;
        for (int i = 0; i < 5; i++) {
            questionService.add("Привет" + i, "Пока" + i);
        }
        assertThat(questionService.getAll()).hasSize(size);
        assertThat(questionService.getRandomQuestion()).isIn(questionService.getAll()); // проверям методом isIn что вопрос из переданного множества
    }
    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("Как дела", "Нормально"),
                Arguments.of("Что делаешь", "Сижу"),
                Arguments.of("Как мне жить?", "Не тужить"),
                Arguments.of("Что делать?", "Мечтать"),
                Arguments.of("Как учиться?", "Через нехочу"),
                Arguments.of("Как любить?", "Чтобы не забыть")
        );
    }
    public static Stream<Arguments> questions() {
        return Stream.of(
                Arguments.of(new Question("Что делать?", "Жить")),
                Arguments.of(new Question("Что делать?", "Думать")),
                Arguments.of(new Question("Что делать?", "Творить")),
                Arguments.of(new Question("Что делать?", "Мечтать")),
                Arguments.of(new Question("Что делать?", "Страдать")),
                Arguments.of(new Question("Что делать?", "Исполнять")
                ));
    }

//    public static Stream<Arguments> questionsNegative() {
//        return Stream.of(
//                Arguments.of(new Question("Что делать?", "Мыслить")),
//                Arguments.of(new Question("Что делать?", "Шить")),
//                Arguments.of(new Question("Что делать?", "Мыть")),
//                Arguments.of(new Question("Что делать?", "Печь")),
//                Arguments.of(new Question("Что делать?", "Кодить")),
//                Arguments.of(new Question("Что делать?", "Плыть")
//                ));
//    }
}