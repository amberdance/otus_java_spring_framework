package ru.otus.util;

import ru.otus.model.Answer;

public class CsvAnswerMapper implements Mapper<Answer> {


    @Override
    public Answer map(String[] args) {
        return new Answer(args[0]);
    }
}
