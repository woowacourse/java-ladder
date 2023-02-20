package view;

import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Point;

public class OutputView {

    private static final OutputView outputView = new OutputView();

    private final String BLANK = " ";
    private final String LINE_START_FORMAT = "    |";
    private final String NAME_START_FORMAT = "  ";
    private final int DIVISOR = 2;
    private final int DEFAULT_PADDING = 2;
    private final int FLAG = 1;

    public static OutputView getOutputView() {
        return outputView;
    }

    public void printNames(Players players) {
        System.out.print(NAME_START_FORMAT);
        players.getPlayers().stream()
                .map(Player::getName)
                .forEach(outputView::printName);
        System.out.println();
    }

    private void printName(String name) {
        String formattedName = generateCentralFormattedName(name);
        System.out.print(formattedName + BLANK);
    }

    private String generateCentralFormattedName(String name) {
        int length = name.length();
        int leftPadding = DEFAULT_PADDING - length / DIVISOR;
        int rightPadding = DEFAULT_PADDING - (length - FLAG) / DIVISOR;
        return BLANK.repeat(leftPadding) + name + BLANK.repeat(rightPadding);
    }

    public void printLadder(Ladder ladder) {
        ladder.getLadder().forEach(outputView::printLine);
    }

    private void printLine(Line line) {
        List<Point> points = line.getPoints();
        StringBuilder result = new StringBuilder(LINE_START_FORMAT);
        points.forEach(point -> result.append(point.toFormattedStatus()));
        System.out.println(result);
    }
}
