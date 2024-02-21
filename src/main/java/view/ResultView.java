package view;

import domain.Line;
import domain.Lines;
import domain.Names;

public class ResultView {
    private ResultView() {
    }

    public static void printResult(Names names, Lines lines) {
        printResultNotice();
        printNames(names);
        printLines(names, lines);
    }

    private static void printLines(Names names, Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(ResultMessage.ladderPadding(names));
            System.out.print(ResultMessage.of(line));
        }
    }

    private static void printNames(Names names) {
        String firstName = names.firstName() + " ";
        StringBuilder nameLine = new StringBuilder();

        for (int i = 1; i < names.size(); i++) {
            nameLine.append(String.format("%6s", names.nameOf(i)));
        }
        System.out.println(firstName + nameLine);
    }

    private static void printResultNotice() {
        System.out.println();
        System.out.println("실행결과\n");
    }
}
