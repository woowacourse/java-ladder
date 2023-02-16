package view;

import domain.Ladder;
import domain.Line;
import domain.PointStatus;
import domain.Users;

public class OutputView {
    private static final String OUTPUT_EXECUTE_MESSAGE = "실행결과";

    public void printLadderGameResult(Users users, Ladder ladder) {
        System.out.println(OUTPUT_EXECUTE_MESSAGE);
        System.out.println(String.join(" ", users.getUserNames()));
    }

    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
        }
    }


    private void printLine(Line line) {
        for (boolean point : line.getPoints()) {
            printLineByPoint(point);
        }
    }

    private void printLineByPoint(boolean point) {
        System.out.print(PointStatus.printStatus(point, 5));
        System.out.print("|");
    }
}
