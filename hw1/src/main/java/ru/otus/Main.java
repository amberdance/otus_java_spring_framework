package ru.otus;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.model.Question;
import ru.otus.service.QuestionService;
import ru.otus.util.DataReader;
import ru.otus.util.Mapper;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        var ctx = prepareContext();
        var questionService = ctx.getBean(QuestionService.class);

        printQuestions(questionService.getAllQuestions());
    }

    @SuppressWarnings("unchecked")
    private static ClassPathXmlApplicationContext prepareContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        DataReader<List<String[]>> reader = context.getBean(DataReader.class);
        Mapper<Question> questionMapper = context.getBean(Mapper.class);
        List<Question> dataSource = context.getBean(List.class);

        reader.read().forEach(line -> dataSource.add(questionMapper.map(line)));

        return context;
    }

    private static void printQuestions(List<Question> questions) {
        printWatermark();

        for (int i = 0; i < questions.size(); i++) {
            var currentQuestion = questions.get(i);

            System.out.printf("Question %d: %s\n", (i + 1), currentQuestion.getName());
            System.out.println("Answers:");

            currentQuestion.getAnswers().forEach(a -> System.out.println("- " + a.getName()));
            System.out.println();
        }
    }

    private static void printWatermark() {
        System.out.println("""

                       __                     ____  __                _____            _           \s
                      / /___ __   ______ _   / __ \\/ /___  _______   / ___/____  _____(_)___  ____ _
                 __  / / __ `/ | / / __ `/  / / / / __/ / / / ___/   \\__ \\/ __ \\/ ___/ / __ \\/ __ `/
                / /_/ / /_/ /| |/ / /_/ /  / /_/ / /_/ /_/ (__  )   ___/ / /_/ / /  / / / / / /_/ /\s
                \\____/\\__,_/ |___/\\__,_/   \\____/\\__/\\__,_/____/   /____/ .___/_/  /_/_/ /_/\\__, / \s
                                                                       /_/                 /____/  \s
                """);
    }
}
