package view;

import java.util.List;

public class OutputView {

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printResultMessage() {
        System.out.println("\n실행결과\n");
    }

    public static void printUserNames(List<String> userNames) {
        String parsedUserNames = String.join(" ", userNames);
        System.out.println(parsedUserNames);
    }

    public static void printLadder(List<String> ladder) {
        ladder.forEach(System.out::println);
    }
}
