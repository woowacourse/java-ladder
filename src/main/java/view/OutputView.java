package view;

import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Names;
import domain.Point;

public class OutputView {

    private static final String BLANK = " ";
    private static final String DIVIDER = "|";
    private static final String LINE_START_FORMAT = "    ";
    private static final String NAME_START_FORMAT = "  ";
    private static final String CONNECTED = "-----";
    private static final String DISCONNECTED = "     ";
    private static final int DIVISOR = 2;
    private static final int DEFAULT_PADDING = 2;
    private static final int FLAG = 1;

    public static void printNames(Names names) {
        System.out.print(NAME_START_FORMAT);

        names.getNames()
                .stream()
                .map(Name::getName)
                .forEach(OutputView::printName);

        System.out.println();
    }

    private static void printName(String name) {
        String alignedName = alignCenter(name);

        System.out.print(alignedName + BLANK);
    }

    private static String alignCenter(String name) {
        int length = name.length();

        int leftPadding = DEFAULT_PADDING - length / DIVISOR;
        int rightPadding = DEFAULT_PADDING - (length - FLAG) / DIVISOR;

        return BLANK.repeat(leftPadding) + name + BLANK.repeat(rightPadding);
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLadder()
                .forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        List<Point> points = line.getPoints();

        StringBuilder result = new StringBuilder(LINE_START_FORMAT + DIVIDER);
        for (Point point : points) {
            result.append(toStatus(point));
        }

        System.out.println(result);
    }

    private static String toStatus(Point point) {
        if (point.isConnected()) {
            return CONNECTED + DIVIDER;
        }

        return DISCONNECTED + DIVIDER;
    }
}
