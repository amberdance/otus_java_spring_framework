package ru.otus.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PrettyAwesomeWatermark {

    public static void printWatermark() {
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
