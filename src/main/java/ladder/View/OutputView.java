package ladder.View;

import ladder.domain.Direction;
import ladder.domain.Line;
import ladder.domain.Player;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String OUTPUT_LADDER_RESULT = "사다리 결과";
    private static final int MAX_INTERVAL = 5;
    private static final String ROW_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String NAME_INTERVAL = " ";
    private static final String COL_LINE = "|";
    private static final String NEXT_LINE = "\n";
    private static StringBuilder stringBuilder;

    public static void ladderGameResult(List<Player> players, List<Line> ladder, Map<Integer, String> rewards) {
        ladderResult(players, ladder, rewards);
    }

    private static void ladderResult(List<Player> players, List<Line> ladder, Map<Integer, String> rewards) {
        stringBuilder = new StringBuilder();
        System.out.println(OUTPUT_LADDER_RESULT);
        printPlayers(players);
        printLadder(ladder);
        printReward(rewards);
        System.out.println(stringBuilder.toString());
    }

    private static void printPlayers(List<Player> players) {
        for (Player player : players) {
            stringBuilder.append(printInterval(player.getName().length()));
            stringBuilder.append(player.getName());
        }
        stringBuilder.append(NEXT_LINE);
    }

    private static StringBuilder printInterval(int inputLength) {
        StringBuilder stringBuilder = new StringBuilder();
        int interval = MAX_INTERVAL - inputLength;
        for (int i = interval; i >= 0; i--) {
            stringBuilder.append(NAME_INTERVAL);
        }

        return stringBuilder;
    }

    private static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            for (Direction direction : line.getLine()) {
                stringBuilder.append(direction.isLeft() ? ROW_LINE : EMPTY_LINE);
                stringBuilder.append(COL_LINE);
            }
            stringBuilder.append(NEXT_LINE);
        }
    }

    private static void printReward(Map<Integer, String> rewards) {
        Collection<String> values = rewards.values();
        for (String value : values) {
            stringBuilder.append(printInterval(value.length()));
            stringBuilder.append(value);
        }
        stringBuilder.append(NEXT_LINE);
    }
}
