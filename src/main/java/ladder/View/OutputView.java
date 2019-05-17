package ladder.View;

import ladder.domain.Line;
import ladder.domain.Player;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_LADDER_RESULT = "사다리 결과";
    private static final int MAX_INTERVAL = 5;
    private static final String ROW_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String NAME_INTERVAL = " ";
    private static final String COL_LINE = "|";
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

    public static void printLadderResult(List<Player> players) {
        stringBuilder = new StringBuilder();
        System.out.println(OUTPUT_LADDER_RESULT);
        printPlayers(players);
        System.out.println(stringBuilder.toString());
    }

    private static void printPlayers(List<Player> players) {
        for (Player player : players) {
            stringBuilder.append(printInterval(player.getName().length()));
            stringBuilder.append(player.getName());
        }
    }

    private static StringBuilder printInterval(int playerNameLength) {
        StringBuilder stringBuilder = new StringBuilder();
        int interval = MAX_INTERVAL - playerNameLength;
        for (int i = interval; i >= 0; i--) {
            stringBuilder.append(NAME_INTERVAL);
        }

        return stringBuilder;
    }

}
