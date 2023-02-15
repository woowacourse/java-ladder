package view;

import domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_FORMAT = "    |%s|";
    private static final String RESULT_MESSAGE = "\n실행결과";

    public void printUsers(List<String> users) {
        System.out.println(RESULT_MESSAGE);
        for (String user : users) {
            System.out.printf("%5s ", user);
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        String collect = ladder.getLadder().stream()
                .map(i -> i ? "-".repeat(5) : " ".repeat(5))
                .collect(Collectors.joining("|"));
        System.out.println(String.format(LADDER_FORMAT, collect));
    }
}
