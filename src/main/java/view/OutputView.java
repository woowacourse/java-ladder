package view;

import domain.ladder.Line;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_SHOW_MESSAGE = "사다리결과";
    private static final String PLAYERS_RESULT_MESSAGE = "실행결과";
    private static final String LINE_BAR_MESSAGE = "|";
    private static final String LINE_SPACE_MESSAGE = "    ";
    private static final String RESULT_SPLIT_MESSAGE = " : ";
    private static final String PLAYER_SHOW_FORMAT = "%5s ";
    private static final String POINT_SHOW_FORMAT = "%s";
    private static final String ALL_PLAYERS_RESULT_MESSAGE = "all";
    private static final String LINE_CHANGE_MESSAGE= "";

    public static void showResultMessage() {
        System.out.println(RESULT_SHOW_MESSAGE);
    }

    public static void showPlayers(List<String> playerNames) {
        playerNames.forEach(name -> printMessageFormat(name, PLAYER_SHOW_FORMAT));
        printMessage(LINE_CHANGE_MESSAGE);
    }

    public static void showLadder(List<Line> lines) {
        for (Line line : lines) {
            showPoints(line.getPoints());
            printMessage(LINE_CHANGE_MESSAGE);
        }
    }

    public static void showPrizes(List<String> prizes) {
        prizes.forEach(prize -> printMessageFormat(prize, PLAYER_SHOW_FORMAT));
        printMessage(LINE_CHANGE_MESSAGE);
    }

    public static void showGameResult(Map<String, String> gameResult, String name) {
        if (name.equals(ALL_PLAYERS_RESULT_MESSAGE)) {
            showAllPlayersOutcome(gameResult);
            return;
        }
        showPlayerOutcome(name, gameResult.get(name));
    }

    private static void showPoints(List<Boolean> points) {
        System.out.print(LINE_SPACE_MESSAGE + LINE_BAR_MESSAGE);
        for (Boolean point : points) {
            printMessageFormat(Point.getPoint(point).getMessage() + LINE_BAR_MESSAGE, POINT_SHOW_FORMAT);
        }
    }

    private static void showPlayerOutcome(String name, String prize) {
        printMessage(PLAYERS_RESULT_MESSAGE);
        printMessage(name + RESULT_SPLIT_MESSAGE + prize);
    }

    private static void showAllPlayersOutcome(Map<String, String> allResults) {
        printMessage(PLAYERS_RESULT_MESSAGE);
        for (Map.Entry<String, String> entry : allResults.entrySet()) {
            printMessage(entry.getKey() + RESULT_SPLIT_MESSAGE + entry.getValue());
        }
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printMessageFormat(String playerName, String format) {
        System.out.printf(format, playerName);
    }
}
