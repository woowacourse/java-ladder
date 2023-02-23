package view;

import domain.Ladder.Ladder;
import domain.Ladder.Line;
import domain.util.Point;

import java.util.stream.Collectors;

public class LadderView {
    private final static String ABSENT_LINE = "     ";
    private final static String PRESENT_LINE = "-----";
    private final static String LADDER_DELIMITER = "|";
    private final static String PREFIX = "     |";
    private final static String SUFFIX = "|";

    public static String formatLadder(Ladder ladder) {
        return ladder.getLines().stream()
                .map(LadderView::formatLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static String formatLine(Line line) {
        return line.getPoints().stream()
                .map(LadderView::formatPoint)
                .collect(Collectors.joining(LADDER_DELIMITER, PREFIX, SUFFIX));
    }

    public static String formatPoint(Point point) {
        if (point.isPresent()) {
            return PRESENT_LINE;
        }
        return ABSENT_LINE;
    }
}
