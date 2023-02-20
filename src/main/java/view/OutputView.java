package view;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.player.Player;

import java.util.List;

public class OutputView {

    private static final String RESULT_SHOW_MESSAGE = "실행결과";
    private static final String LINE_BAR_MESSAGE = "|";
    private static final String LINE_SPACE_MESSAGE = "    ";
    private static final String PLAYER_SHOW_FORMAT = "%5s ";
    private static final String POINT_SHOW_FORMAT = "%s";

    public static void showResultMessage() {
        System.out.println(RESULT_SHOW_MESSAGE);
    }

    public static void showPlayers(List<Player> players) {
        players.forEach(player -> printMessageFormat(player.getName(), PLAYER_SHOW_FORMAT));
        System.out.println();
    }

    public static void showLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            showPoints(line.getPoints());
            System.out.println();
        }
    }

    private static void showPoints(List<Boolean> points) {
        System.out.print(LINE_SPACE_MESSAGE + LINE_BAR_MESSAGE);
        for (Boolean point : points) {
            printMessageFormat(Point.getPoint(point).getMessage() + LINE_BAR_MESSAGE, POINT_SHOW_FORMAT);
        }
    }

    private static void printMessageFormat(String playerName, String format) {
        System.out.printf(format, playerName);
    }
}
