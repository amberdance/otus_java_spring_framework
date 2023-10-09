package ru.otus.service;

import lombok.RequiredArgsConstructor;
import ru.otus.model.Question;
import ru.otus.repository.QuestionRepository;
import ru.otus.util.PrettyAwesomeWatermark;

import java.util.List;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final IOService ioService;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findQuestions();
    }

    @Override
    public void printQuestions() {
        PrettyAwesomeWatermark.printWatermark();
        var questions = questionRepository.findQuestions();

        for (int i = 0; i < questions.size(); i++) {
            var currentQuestion = questions.get(i);

            ioService.printLine(String.format("Question %d: %s\n", (i + 1), currentQuestion.getName()));
            ioService.printLine("Answers:");

            currentQuestion.getAnswers().forEach(a -> System.out.println("- " + a.getName()));
            ioService.printBlankLine();
        }
    }

}
