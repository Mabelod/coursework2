package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach() {
        List<Question> questions = List.of(
                new Question("Что делать?", "Мыслить"),
                new Question("Что делать?", "Шить"),
                new Question("Что делать?", "Мыть"),
                new Question("Что делать?", "Печь"),
                new Question("Что делать?", "Кодить"),
                new Question("Что делать?", "Плыть")
        );
        when(questionService.getAll()).thenReturn(questions);
    }

    @ParameterizedTest
    @MethodSource("params")
    void getQuestions(int amount) { // не понимаю как сделать проверьку данного метода

    }

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(4),
                Arguments.of(5),
                Arguments.of(6)
        );
    }
}