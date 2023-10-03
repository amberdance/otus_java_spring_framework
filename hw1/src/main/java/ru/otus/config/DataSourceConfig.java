package ru.otus.config;

import ru.otus.model.Question;
import ru.otus.util.CsvDataReader;
import ru.otus.util.CsvQuestionMapper;

import java.util.List;


public class DataSourceConfig {

    private final List<Question> dataSource;
    private final CsvQuestionMapper csvQuestionMapper;
    private final CsvDataReader csvDataReader;

    public DataSourceConfig(List<Question> dataSource, CsvQuestionMapper csvQuestionMapper,
                            CsvDataReader csvDataReader) {
        this.dataSource = dataSource;
        this.csvQuestionMapper = csvQuestionMapper;
        this.csvDataReader = csvDataReader;

        configureDatasource();
    }

    public void configureDatasource() {
        csvDataReader.read().forEach(line -> dataSource.add(csvQuestionMapper.map(line)));
    }
}
