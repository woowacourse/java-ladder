package view;

import domain.Game;
import domain.Line;
import domain.Lines;
import domain.Members;
import domain.Point;
import domain.Result;
import domain.Results;

public class OutputView {

    public static final int MAX_NAME_LENGTH = 5;

    public void printGame(Game game) {
        System.out.println("사다리 결과");
        printMembers(game.getMembers());
        printLines(game.getLines());
        printResults(game.getResults());
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

    private void printResults(Results results) {
        for (Result result : results.getResults()) {
            printResult(result);
        }
        System.out.println();
    }

    private void printResult(Result result) {
        if (result.getName().equals("꽝")) {
            System.out.printf("%" + (MAX_NAME_LENGTH - 1) + "s ", result.getName());
            return;
        }
        System.out.printf("%" + MAX_NAME_LENGTH + "s ", result.getName());
    }
}
