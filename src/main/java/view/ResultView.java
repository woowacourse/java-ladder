package view;

import domain.Line;
import domain.Lines;
import domain.Names;

public class ResultView {
    private static final String MOVABLE_LINE = "-----|";
    private static final String UNMOVABLE_LINE = "     |";

    public static void printResult(Names names, Lines lines) {
        printResultNotice();
        printNames(names);
        printLines(names, lines);
    }

    private static void printLines(Names names, Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(" ".repeat(names.getNames().get(0).getName().length()) + "|");
            for (Boolean point : line.getPoints()) {
                if (point) {
                    System.out.print(MOVABLE_LINE);
                } else {
                    System.out.print(UNMOVABLE_LINE);
                }
            }
            System.out.println();
        }
    }

    private static void printNames(Names names) {
        String firstName = String.format("%-5s", names.getNames().get(0).getName());
        String nextLine = "";
        for (int i = 1; i<names.getNames().size(); i++) {
            nextLine += String.format("%6s", names.getNames().get(i).getName());
        }
        System.out.println(firstName + nextLine);
    }

    private static void printResultNotice() {
        System.out.println("실행결과\n");
    }
}
