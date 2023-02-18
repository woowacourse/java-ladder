package view;

import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Point;

public class OutputView {

    private static final String BLANK = " ";
    private static final String LINE_START_FORMAT = "    |";
    private static final String NAME_START_FORMAT = "  ";
    private static final int DIVISOR = 2;
    private static final int DEFAULT_PADDING = 2;
    private static final int FLAG = 1;

    public static void printNames(Players players) {
        System.out.print(NAME_START_FORMAT);
        players.getPlayers().stream()
                .map(Player::getName)
                .forEach(OutputView::printName);
        System.out.println();
    }

    private static void printName(String name) {
        String formattedName = generateCentralFormattedName(name);
        System.out.print(formattedName + BLANK);
    }

    private static String generateCentralFormattedName(String name) {
        int length = name.length();
        int leftPadding = DEFAULT_PADDING - length / DIVISOR;
        int rightPadding = DEFAULT_PADDING - (length - FLAG) / DIVISOR;
        return BLANK.repeat(leftPadding) + name + BLANK.repeat(rightPadding);
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLadder().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        List<Point> points = line.getPoints();
        StringBuilder result = new StringBuilder(LINE_START_FORMAT);
        for (Point point : points) {
            result.append(point.toFormattedStatus());
        }
        System.out.println(result);
    }
}
