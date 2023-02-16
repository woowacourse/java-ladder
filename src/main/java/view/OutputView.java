package view;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.Point;
import domain.player.Player;

import java.util.List;

public class OutputView {

    private static final String RESULT_SHOW_MESSAGE = "실행결과";
    private static final String LINE_BAR_MESSAGE = "|";
    private static final String LINE_SPACE_MESSAGE = "    ";
    private static final String PLAYER_SHOW_FORMAT = "%5s ";
    private static final String POINT_SHOW_FORMAT = "%s";

    public void showResultMessage() {
        System.out.println(RESULT_SHOW_MESSAGE);
    }

    public void showPlayers(List<Player> players) {
        players.forEach(player -> printMessageFormat(player.getName(), PLAYER_SHOW_FORMAT));
        System.out.println();
    }

    public void showLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            List<Boolean> points = line.getPoints();
            showPoints(points);
            System.out.println();
        }
    }

    private void showPoints(List<Boolean> points) {
        System.out.printf(LINE_SPACE_MESSAGE + LINE_BAR_MESSAGE);
        for (Boolean point : points) {
            printMessageFormat(Point.getPoint(point).getMessage() + LINE_BAR_MESSAGE, POINT_SHOW_FORMAT);
        }
    }

    private void printMessageFormat(String playerName, String format) {
        System.out.printf(format, playerName);
    }
}
