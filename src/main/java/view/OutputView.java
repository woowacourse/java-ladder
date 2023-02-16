package view;

import domain.Line;
import domain.Player;
import domain.Point;

import java.util.List;

public class OutputView {

    private static final String RESULT_SHOW_MESSAGE = "실행결과";
    private static final String LINE_BAR_MESSAGE = "|";

    public void showResultMessage() {
        System.out.println(RESULT_SHOW_MESSAGE);
    }

    public void showPlayers(List<Player> players) {
        for (Player player : players) {
            printMessageFormat(player.getName(), "%5s ");
        }
        System.out.println();
    }

    public void showLadder(List<Line> lines) {
        for (Line line : lines) {
            List<Boolean> points = line.getPoints();
            System.out.print("    " + LINE_BAR_MESSAGE);
            for (Boolean point : points) {
                printMessageFormat(Point.getPoint(point).getMessage() + LINE_BAR_MESSAGE, "%s");
            }
            System.out.println();
        }
    }

    private void printMessageFormat(String playerName, String format) {
        System.out.printf(format, playerName);
    }
}
