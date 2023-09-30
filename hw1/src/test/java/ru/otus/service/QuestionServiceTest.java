package ru.otus.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.model.Question;
import ru.otus.repository.QuestionRepositoryImpl;
import ru.otus.util.AbstractTest;
import ru.otus.util.CsvQuestionMapper;
import ru.otus.util.Mapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionServiceTest extends AbstractTest {

    private static final List<Question> dataSource = new ArrayList<>();
    private static QuestionService questionService;

    @BeforeEach
    void setUp() {
        dataSource.clear();
        Mapper<Question> questionMapper = new CsvQuestionMapper();
        dataReader.read().forEach(line -> dataSource.add(questionMapper.map(line)));
        var questionRepository = new QuestionRepositoryImpl(dataSource);
        questionService = new QuestionServiceImpl(questionRepository);
    }


    @Test
    @DisplayName("Должен возвращать список имеющихся вопросов из источника данных")
    void getAllQuestions() {
        assertEquals(EXPECTED_LINES_OF_FILE, questionService.getAllQuestions().size());
    }

    @Test
    @DisplayName("Запрет на попытки модифицировать список вопрос из метода getAllQuestions")
    void testThrowsException() {
        var questions = questionService.getAllQuestions();
        assertThrows(UnsupportedOperationException.class, () -> questions.remove(0));
    }
}
