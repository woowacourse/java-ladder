package ladder.View;

import ladder.domain.Line;
import ladder.domain.Player;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class OutputView {
    private static final String OUTPUT_LADDER_RESULT = "사다리 결과";
    private static final int MAX_INTERVAL = 5;
    private static final String ROW_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String NAME_INTERVAL = " ";
    private static final String COL_LINE = "|";
    private static final String COLON = " : ";
    private static final String OUTPUT_PLAYER_RESULT = "실행 결과";

    private static StringBuilder stringBuilder;

    public static void printLadder(Line line) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(EMPTY_LINE);
        stringBuilder.append(COL_LINE);
        for (Boolean rowLine : line.getRowLines()) {
            stringBuilder.append(rowLine ? ROW_LINE : EMPTY_LINE);
            stringBuilder.append(COL_LINE);
        }

        System.out.println(stringBuilder.toString());
    }

    public static void printNames(List<String> names) {
        stringBuilder = new StringBuilder();
        System.out.println(OUTPUT_LADDER_RESULT);
        printPlayers(names);
        System.out.println(stringBuilder.toString());
    }

    private static void printPlayers(List<String> names) {
        for (String name : names) {
            stringBuilder.append(printInterval(name.length()));
            stringBuilder.append(name);
        }
    }

    public static void printExecuteResult(List<String> executeResult) {
        stringBuilder = new StringBuilder();
        for (String result : executeResult) {
            stringBuilder.append(printInterval(result.length()));
            stringBuilder.append(result);
        }

        System.out.println(stringBuilder.toString());
    }

    private static StringBuilder printInterval(int playerNameLength) {
        StringBuilder stringBuilder = new StringBuilder();
        int interval = MAX_INTERVAL - playerNameLength;
        for (int i = interval; i >= 0; i--) {
            stringBuilder.append(NAME_INTERVAL);
        }

        return stringBuilder;
    }

    public static void printMatchedExecuteResult(List<Player> players, String playerForResult, List<String> executeResult) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(OUTPUT_PLAYER_RESULT + "\n");

        if (playerForResult.equals("all")) {
            outputAllPlayerResult(players, executeResult);
            return;
        }
        outputPlayerResult(players, playerForResult, executeResult);

    }

    private static void outputAllPlayerResult(List<Player> players, List<String> executeResult) {
        for (Player player : players ) {
            stringBuilder.append(player.getName() + COLON);
            stringBuilder.append(executeResult.get(player.getPosition()) + "\n");
        }

        System.out.println(stringBuilder.toString());
    }

    private static void outputPlayerResult(List<Player> players, String playerForResult, List<String> executeResult) {
        AtomicBoolean findResult = new AtomicBoolean(false);
        for (Player player : players) {
            findResult.set(checkContainsPlayer(player, playerForResult, executeResult));
        }

        System.out.println(stringBuilder.toString());
    }

    private static boolean checkContainsPlayer(Player player, String playerForResult, List<String> executeResult) {
        if (playerForResult.contains(player.getName())) {
            stringBuilder.append(player.getName() + COLON);
            stringBuilder.append(executeResult.get(player.getPosition()) + "\n");
            return true;
        }
        return false;
    }

}
