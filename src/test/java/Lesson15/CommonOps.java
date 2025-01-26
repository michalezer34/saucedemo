package Lesson15;

import io.qameta.allure.Step;

public class CommonOps {
    @Step("{0}")
    public static void logToReport(String message) {
        System.out.println(message);
    }

}
