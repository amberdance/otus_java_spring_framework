package ru.otus.util;

import ru.otus.model.Answer;
import ru.otus.model.Question;

import java.util.ArrayList;
import java.util.List;

public class CsvQuestionMapper {


    public Question map(String[] args) {
        var name = args[0];
        List<Answer> answers = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            answers.add(new Answer(args[i].replace("\r", "")));
        }

        return new Question(name, answers);
    }
}
