package ru.otus.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CsvDataReaderTest extends AbstractTest {


    @Test
    @DisplayName("При отсутствии файла выбрасывает исключение")
    void when_FileNotExists_then_ExceptionThrew() {
       var dataReader = new CsvDataReader("test.csv");
        assertThrows(RuntimeException.class, dataReader::read);
    }

    @Test
    @DisplayName("При наличии файла возвращает корректный список с строками")
    void when_FileExists_then_ListOfLinesReturned() {
        assertEquals(EXPECTED_LINES_OF_FILE, dataReader.read().size());
    }
}
