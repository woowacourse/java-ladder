package view;

import domain.Game;
import domain.Line;
import domain.Lines;
import domain.Members;
import domain.Point;

public class OutputView {

    public static final int MAX_NAME_LENGTH = 5;

    public void printResult(Game game) {
        System.out.println("실행결과");
        printMembers(game.getMembers());
        printLines(game.getLines());
    }

    public void printMembers(Members members) {
        for (String name : members.getNames()) {
            System.out.printf("%" + MAX_NAME_LENGTH + "s ", name);
        }
        System.out.println();
    }

    public void printLines(Lines lines) {
        for (Line line : lines.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        System.out.print(" ".repeat(MAX_NAME_LENGTH - 1));
        System.out.print("|");
        for (Point point : line.getPoints()) {
            printPoint(point);
            System.out.print("|");
        }
        System.out.println();
    }

    private void printPoint(Point point) {
        if (point.equals(Point.CONNECTED)) {
            System.out.print("-".repeat(MAX_NAME_LENGTH));
            return;
        }
        System.out.print(" ".repeat(MAX_NAME_LENGTH));
    }
}
