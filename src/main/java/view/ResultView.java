package view;

import domain.Ladder;
import domain.SingleLine;
import domain.Line;

import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void printNames(final List<String> userNames) {
        System.out.println("실행결과");
        System.out.println();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%-5s", userNames.get(0)));

        for (int i = 1; i < userNames.size() - 1; i++) {
            stringBuilder.append(String.format("%6s", userNames.get(1)));
        }
        stringBuilder.append(String.format("%5s", userNames.get(userNames.size() - 1)));
        System.out.println(stringBuilder);
    }

    public static void printResult(final Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            System.out.println(SingleLine.generateSingleLine(line));
        }
    }
}
