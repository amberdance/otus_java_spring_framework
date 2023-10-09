package ru.otus.repository;

import lombok.RequiredArgsConstructor;
import ru.otus.model.Question;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

    private final List<Question> dataSource;

    @Override
    public List<Question> findQuestions() {
        return Collections.unmodifiableList(dataSource);
    }
}
