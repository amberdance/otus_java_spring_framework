package ru.otus.service;

import ru.otus.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();

    void printQuestions();
}
