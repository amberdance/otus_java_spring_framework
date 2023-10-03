package ru.otus.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.model.Question;
import ru.otus.repository.QuestionRepository;
import ru.otus.repository.QuestionRepositoryImpl;
import ru.otus.util.CsvDataReader;
import ru.otus.util.CsvQuestionMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionServiceTest {

    private static final byte EXPECTED_LINES_OF_FILE = 5;
    private static final CsvDataReader dataReader = new CsvDataReader("qna.csv");
    private static final List<Question> dataSource = new ArrayList<>();
    private static final CsvQuestionMapper questionMapper = new CsvQuestionMapper();
    private static final QuestionRepository questionRepository = new QuestionRepositoryImpl(dataSource);
    private static final QuestionService questionService = new QuestionServiceImpl(questionRepository, new ConsoleIOService());

    @BeforeEach
    void setUp() {
        dataSource.clear();
        dataReader.read().forEach(line -> dataSource.add(questionMapper.map(line)));
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
