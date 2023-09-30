package ru.otus.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CsvDataReaderTest {

    private static final byte EXPECTED_LINES_OF_FILE = 5;
    private static final DataReader<List<String[]>> dataReader = new CsvDataReader("qna.csv");


    @Test
    @DisplayName("При отсутствии файла выбрасывает исключение")
    void when_FileNotExists_then_ExceptionThrew() {
        DataReader<List<String[]>> dataReader = new CsvDataReader("test.csv");
        assertThrows(RuntimeException.class, dataReader::read);
    }

    @Test
    @DisplayName("При наличии файла возвращает корректный список с строками")
    void when_FileExists_then_ListOfLinesReturned() {
        assertEquals(EXPECTED_LINES_OF_FILE, dataReader.read().size());
    }
}
