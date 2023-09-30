package ru.otus.util;

import java.util.List;

public class AbstractTest {

    protected static final byte EXPECTED_LINES_OF_FILE = 5;
    protected static final DataReader<List<String[]>> dataReader = new CsvDataReader("qna.csv");

}
