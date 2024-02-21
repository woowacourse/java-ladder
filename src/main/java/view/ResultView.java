package view;

import domain.Ladder;
import domain.SingleLine;
import domain.Line;
import domain.Users;

import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void printNames(final Users users) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(users.getFirst()).append(" ");
        users.getMiddleUsers().forEach(userName -> stringBuilder.append(String.format("%6s", userName)));
        stringBuilder.append(String.format("%5s", users.getLast()));

        System.out.println(stringBuilder);
    }

    public static void printResultMessage() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printResult(final Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            System.out.println(SingleLine.generateSingleLine(line));
        }
    }
}
