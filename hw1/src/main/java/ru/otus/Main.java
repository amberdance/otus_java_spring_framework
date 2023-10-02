package ru.otus;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.model.Question;
import ru.otus.service.IOService;
import ru.otus.service.QuestionService;
import ru.otus.util.CsvDataReader;
import ru.otus.util.CsvQuestionMapper;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        var ctx = prepareContext();
        var questionService = ctx.getBean(QuestionService.class);
        var ioService = ctx.getBean(IOService.class);

        printQuestions(questionService.getAllQuestions(), ioService);
    }

    @SuppressWarnings("unchecked")
    private static ClassPathXmlApplicationContext prepareContext() {
        var context = new ClassPathXmlApplicationContext("/spring-context.xml");
        var reader = context.getBean(CsvDataReader.class);
        var questionMapper = context.getBean(CsvQuestionMapper.class);
        var dataSource = context.getBean(List.class);

        reader.read().forEach(line -> dataSource.add(questionMapper.map(line)));

        return context;
    }

    private static void printQuestions(List<Question> questions, IOService ioService) {
        printWatermark(ioService);

        for (int i = 0; i < questions.size(); i++) {
            var currentQuestion = questions.get(i);

            ioService.printLine(String.format("Question %d: %s\n", (i + 1), currentQuestion.getName()));
            ioService.printLine("Answers:");

            currentQuestion.getAnswers().forEach(a -> System.out.println("- " + a.getName()));
            ioService.printBlankLine();
        }
    }

    private static void printWatermark(IOService ioService) {
        ioService.printLine("""

                       __                     ____  __                _____            _           \s
                      / /___ __   ______ _   / __ \\/ /___  _______   / ___/____  _____(_)___  ____ _
                 __  / / __ `/ | / / __ `/  / / / / __/ / / / ___/   \\__ \\/ __ \\/ ___/ / __ \\/ __ `/
                / /_/ / /_/ /| |/ / /_/ /  / /_/ / /_/ /_/ (__  )   ___/ / /_/ / /  / / / / / /_/ /\s
                \\____/\\__,_/ |___/\\__,_/   \\____/\\__/\\__,_/____/   /____/ .___/_/  /_/_/ /_/\\__, / \s
                                                                       /_/                 /____/  \s
                """);
    }
}
