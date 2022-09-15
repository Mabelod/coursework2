package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.example.RecurringQuestion;
import comexamplecoursework2.example.TheQuestionIsMissing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @ParameterizedTest
    @MethodSource("params")
    void add(String question, String answer) {
        Question expected = new Question(question, answer);
        assertThat(questionService.add(question, answer))
                .isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("questions")
    void testAdd(Question question) {
        assertThat(questionService.add(question)).isEqualTo(question);
    }

    @ParameterizedTest
    @MethodSource("questionsNegative")
    void testAddNegative(Question question) {
        assertThatExceptionOfType(RecurringQuestion.class)
                .isThrownBy(() -> questionService.add(question));
    }

    @ParameterizedTest
    @MethodSource("questionsNegative")
    void remove(Question question) {
        assertThat(questionService.remove(question)).isEqualTo(question);
    }

    @ParameterizedTest
    @MethodSource("questions")
    void removeNegative(Question question) {
        assertThatExceptionOfType(TheQuestionIsMissing.class)
                .isThrownBy(() -> questionService.remove(question));
    }

    @Test
    void getAll() {
        List<Question> expected = new ArrayList<>(List.of(
                new Question("Что делать?", "Мыслить"),
                new Question("Что делать?", "Шить"),
                new Question("Что делать?", "Мыть"),
                new Question("Что делать?", "Печь"),
                new Question("Что делать?", "Кодить"),
                new Question("Что делать?", "Плыть")
        ));
        assertThat(questionService.getAll()).isEqualTo(expected);
    }

    @Test
    void getRandomQuestion() {
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

    public static Stream<Arguments> questionsNegative() {
        return Stream.of(
                Arguments.of(new Question("Что делать?", "Мыслить")),
                Arguments.of(new Question("Что делать?", "Шить")),
                Arguments.of(new Question("Что делать?", "Мыть")),
                Arguments.of(new Question("Что делать?", "Печь")),
                Arguments.of(new Question("Что делать?", "Кодить")),
                Arguments.of(new Question("Что делать?", "Плыть")
                ));
    }
}