package ru.otus;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.model.Question;
import ru.otus.service.IOService;
import ru.otus.service.QuestionService;
import ru.otus.util.PrettyAwesomeWatermark;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        var questionService = ctx.getBean(QuestionService.class);
        var ioService = ctx.getBean(IOService.class);

        printQuestions(questionService.getAllQuestions(), ioService);
    }

    private static void printQuestions(List<Question> questions, IOService ioService) {
        PrettyAwesomeWatermark.printWatermark();

        for (int i = 0; i < questions.size(); i++) {
            var currentQuestion = questions.get(i);

            ioService.printLine(String.format("Question %d: %s\n", (i + 1), currentQuestion.getName()));
            ioService.printLine("Answers:");

            currentQuestion.getAnswers().forEach(a -> System.out.println("- " + a.getName()));
            ioService.printBlankLine();
        }
    }


}
