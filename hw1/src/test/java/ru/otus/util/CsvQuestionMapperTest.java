package ru.otus.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvQuestionMapperTest {

    private static final CsvQuestionMapper questionMapper = new CsvQuestionMapper();
    private static final List<Question> questions = new ArrayList<>();
    private static final byte EXPECTED_LINES_OF_FILE = 5;
    private static final CsvDataReader dataReader = new CsvDataReader("qna.csv");

    @Test
    @DisplayName("Должен мапить строки в объекты Question")
    void map() {
        dataReader.read().forEach(line -> questions.add(questionMapper.map(line)));
        assertEquals(EXPECTED_LINES_OF_FILE, questions.size());
        questions.forEach(q -> assertTrue(q.getAnswers().size() > 0));
    }
}
