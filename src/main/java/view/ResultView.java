package view;

import domain.Ladder;
import domain.SingleLine;
import domain.Line;

public class ResultView {

    public static void printNames(String[] userNames) {
        System.out.println("실행결과");
        System.out.println();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%-5s", userNames[0]));

        for (int i = 1; i < userNames.length - 1; i++) {
            stringBuilder.append(String.format("%6s", userNames[i]));
        }
        stringBuilder.append(String.format("%5s", userNames[userNames.length - 1]));
        System.out.println(stringBuilder);
    }

    public static void printResult(Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            System.out.println(SingleLine.generateSingleLine(line));
        }
    }
}
