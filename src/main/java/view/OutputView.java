package view;

import domain.Ladder;
import domain.Line;
import domain.PointStatus;
import domain.User;
import domain.Users;

public class OutputView {
    private static final String OUTPUT_EXECUTE_MESSAGE = "\n실행결과\n";
    private static final String LINE_DELIMITER = "|";
    private static final String NAME_DELIMITER = " ";

    public void printLadderGameResult(Users users) {
        System.out.println(OUTPUT_EXECUTE_MESSAGE);
        System.out.println(" " + String.join(NAME_DELIMITER, users.getUserNames()));
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
        System.out.print(PointStatus.printStatus(point, User.MAX_NAME_LENGTH));
        System.out.print(LINE_DELIMITER);
    }
}
