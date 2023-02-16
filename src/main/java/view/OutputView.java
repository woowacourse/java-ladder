package view;

import domain.Direction;
import domain.Name;
import domain.PlayerNames;
import domain.Point;
import domain.ladder.Ladder;

public class OutputView {

    private static final int NAME_BOX_SIZE_MAX = 5;
    private static final int BRIDGE_LENGTH = 5;
    private static final String BLANK = " ";
    private static final String RESULT_PREFIX_MESSAGE = "실행결과";
    private static final String EMPTY_BRIDGE = BLANK.repeat(BRIDGE_LENGTH);
    private static final String BRIDGE = "-".repeat(BRIDGE_LENGTH);
    private static final String LINE_COMPONENT = "|";
    private static final String LADDER_PREFIX = BLANK.repeat(2);

    public void printResultPrefix() {
        System.out.println(RESULT_PREFIX_MESSAGE);
    }

    public void printPlayerNames(PlayerNames playerNames) {
        for (Name playerName : playerNames.getNames()) {
            System.out.print(makeName(playerName) + BLANK);
        }
        System.out.println();
    }

    public String makeName(Name playerName) {
        String name = playerName.getName();
        String makeName = name;

        int index = NAME_BOX_SIZE_MAX;
        while (name.length() != index) {
            makeName = appendSpace(makeName, index);
            index--;
        }

        return makeName;
    }

    private String appendSpace(String makeName, int i) {
        if (isFirstAppendable(i)) {
            return BLANK + makeName;
        }

        return makeName + BLANK;
    }

    private boolean isFirstAppendable(int i) {
        return i % 2 == 0;
    }

    public void printResult(Ladder ladder) {
        int lineAmount = ladder.getLines().size();
        for (int pointAt = 0; pointAt < ladder.getHeightSize(); pointAt++) {
            printLadderPrefix();
            printSingleLadder(ladder, lineAmount, pointAt);
            System.out.println();
        }
    }

    private void printSingleLadder(Ladder ladder, int lineAmount, int pointAt) {
        for (int lineAt = 0; lineAt < lineAmount; lineAt++) {
            Point point = ladder.getLines().get(lineAt).getPoints().get(pointAt);
            printPointDirection(point);
        }
    }

    private void printPointDirection(Point point) {
        System.out.print(LINE_COMPONENT);
        if (point.matchDirection(Direction.RIGHT_DOWN)) {
            System.out.print(BRIDGE);
            return;
        }
        System.out.print(EMPTY_BRIDGE);
    }

    private void printLadderPrefix() {
        System.out.print(LADDER_PREFIX);
    }

    public void printError(Exception exception) {
        printErrorMessage(exception.getMessage());
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }

}
