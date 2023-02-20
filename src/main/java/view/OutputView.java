package view;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.LineStatus;
import domain.user.User;
import domain.user.Users;

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
        for (boolean status : line.getLine()) {
            printLineByStatus(status);
        }
    }

    private void printLineByStatus(boolean status) {
        System.out.print(LineStatus.printStatus(status, User.MAX_NAME_LENGTH));
        System.out.print(LINE_DELIMITER);
    }
}
