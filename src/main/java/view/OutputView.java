package view;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.PointStatus;
import domain.user.User;
import domain.user.Users;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OUTPUT_EXECUTE_MESSAGE = "\n사다리 결과\n";
    private static final String LINE_DELIMITER = "|";
    private static final String NAME_DELIMITER = " ";

    public void printLadderGameResult(Users users) {
        System.out.println(OUTPUT_EXECUTE_MESSAGE);
        System.out.println(" " + users.getUserNames()
                .stream()
                .map(this::convertName)
                .collect(Collectors.joining(NAME_DELIMITER)));
    }

    public String convertName(String name) {
        if (name.length() == User.MAX_NAME_LENGTH) {
            return name;
        }
        return insertBlank(name);
    }

    private String insertBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name + " ");
        while (nameBuilder.length() < User.MAX_NAME_LENGTH) {
            nameBuilder.insert(0, " ");
        }
        return nameBuilder.toString();
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
