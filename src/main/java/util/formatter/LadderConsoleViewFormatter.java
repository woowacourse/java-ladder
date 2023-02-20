package util.formatter;

import domain.ladder.Direction;
import domain.ladder.Ladder;
import domain.ladder.Point;

public class LadderConsoleViewFormatter {
    private static final String BLANK = " ";
    private static final String LINE_COMPONENT = "|";
    private static final String LADDER_PREFIX = BLANK.repeat(2);
    private static final int BRIDGE_LENGTH = 5;
    private static final String EMPTY_BRIDGE = BLANK.repeat(BRIDGE_LENGTH);
    private static final String BRIDGE = "-".repeat(BRIDGE_LENGTH);

    public static String formatLadder(Ladder ladder) {
        StringBuilder ladderFormat = new StringBuilder();
        int lineAmount = ladder.getLines().size();
        for (int pointAt = 0; pointAt < ladder.getHeightSize(); pointAt++) {
            ladderFormat.append(LADDER_PREFIX)
                    .append(formatSingleLadder(ladder, lineAmount, pointAt))
                    .append(System.lineSeparator());
        }
        removeLastLineSeparator(ladderFormat);
        return ladderFormat.toString();
    }

    private static String formatSingleLadder(Ladder ladder, int lineAmount, int pointAt) {
        StringBuilder lineFormat = new StringBuilder();
        for (int lineAt = 0; lineAt < lineAmount; lineAt++) {
            Point point = ladder.getPoint(pointAt, lineAt);
            lineFormat.append(LINE_COMPONENT)
                    .append(formatBridge(point));
        }

        return lineFormat.toString().trim();
    }

    private static String formatBridge(Point point) {
        if (point.matchDirection(Direction.RIGHT_DOWN)) {
            return BRIDGE;
        }
        return EMPTY_BRIDGE;
    }

    private static void removeLastLineSeparator(StringBuilder ladderFormat) {
        ladderFormat.deleteCharAt(ladderFormat.length() - 1);
    }
}
