package ru.otus.service;

import lombok.RequiredArgsConstructor;
import ru.otus.model.Question;
import ru.otus.repository.QuestionRepository;

import java.util.List;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findQuestions();
    }
}
