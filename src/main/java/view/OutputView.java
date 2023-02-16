package view;

import java.util.List;

public class OutputView {

    public static void printErrorMessage(final Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printResultMessage() {
        System.out.println("\n실행결과\n");
    }

    public static void printUserNames(final List<String> userNames) {
        String parsedUserNames = String.join(" ", userNames);
        System.out.println(parsedUserNames);
    }

    public static void printLadder(final List<String> ladder) {
        ladder.forEach(System.out::println);
    }
}
