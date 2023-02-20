package view;

import domain.Direction;
import domain.PlayerName;
import domain.PlayerNames;
import domain.Point;
import domain.ResultContent;
import domain.ResultContents;
import domain.ladder.Ladder;

public class OutputView {

    private static final int CONTENT_BOX_SIZE_MAX = 5;
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
        for (PlayerName playerName : playerNames.getPlayerNames()) {
            System.out.print(formatContent(playerName.getPlayerName()) + BLANK);
        }
        breakLine();
    }

    private void breakLine() {
        System.out.print(System.lineSeparator());
    }

    public String formatContent(String content) {
        String formatContent = content;

        int index = CONTENT_BOX_SIZE_MAX;
        while (content.length() != index) {
            formatContent = appendSpace(formatContent, index);
            index--;
        }

        return formatContent;
    }

    private String appendSpace(String formatContent, int index) {
        if (isFirstAppendable(index)) {
            return BLANK + formatContent;
        }

        return formatContent + BLANK;
    }

    private boolean isFirstAppendable(int index) {
        return index % 2 == 0;
    }

    public void printLadder(Ladder ladder) {
        int lineAmount = ladder.getLines().size();
        for (int pointAt = 0; pointAt < ladder.getHeightSize(); pointAt++) {
            printLadderPrefix();
            printSingleLadder(ladder, lineAmount, pointAt);
            breakLine();
        }
    }

    private void printSingleLadder(Ladder ladder, int lineAmount, int pointAt) {
        for (int lineAt = 0; lineAt < lineAmount; lineAt++) {
            Point point = ladder.getPoint(pointAt, lineAt);
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

    public void printResult(ResultContents resultContents) {
        for (ResultContent resultContent : resultContents.getResultContents()) {
            System.out.print(formatContent(resultContent.getContent()) + BLANK);
        }
        breakLine();
    }
}
