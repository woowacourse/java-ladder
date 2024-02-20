package view;

import domain.Ladder;
import domain.Line;

public class ResultView {

    private static final String BAR = "|";

    public static void printNames(String[] userNames) {
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
            System.out.print("    ");
            System.out.print(BAR);
            printSingleLine(line);
            System.out.println();
        }
    }

    private static void printSingleLine(Line line) {
        for (Boolean point : line.getPoints()) {
            System.out.print(convert(point).repeat(5));
            System.out.print(BAR);
        }
    }

    private static String convert(boolean point) {
        if (point) return "-";
        return " ";
    }
}
