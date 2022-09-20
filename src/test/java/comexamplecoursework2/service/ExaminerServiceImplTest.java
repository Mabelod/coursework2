package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;
import comexamplecoursework2.example.LargeNumberOfQuestions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach() {
        Collection<Question> questions = Stream.of(
                new Question("Что делать?", "Мыслить"),
                new Question("Что делать?", "Шить"),
                new Question("Что делать?", "Мыть"),
                new Question("Что делать?", "Печь"),
                new Question("Что делать?", "Кодить"),
                new Question("Что делать?", "Плыть")
        ).collect(Collectors.toSet());
        when(javaQuestionService.getAll()).thenReturn((Set<Question>) questions);
    }

    @ParameterizedTest
    @MethodSource("negativeParams")
    void getQuestionsNegativeTest(int amount) {
        assertThatExceptionOfType(LargeNumberOfQuestions.class)
                .isThrownBy(() -> examinerService.getQuestions(amount));
    }
    @Test
    public void getQuestionsTest() {
        List<Question> questions = new ArrayList<>(javaQuestionService.getAll());

        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(0),
                questions.get(2),
                questions.get(1)
        );
        assertThat(examinerService.getQuestions(3)).containsExactly(questions.get(0), questions.get(1), questions.get(2));

        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(2),
                questions.get(2),
                questions.get(3),
                questions.get(5),
                questions.get(4)
        );

        assertThat(examinerService.getQuestions(6)).containsExactly(questions.get(0), questions.get(1), questions.get(2), questions.get(3), questions.get(4), questions.get(5));

    }

    public static Stream<Arguments> negativeParams() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(0),
                Arguments.of(7)
        );
    }
}