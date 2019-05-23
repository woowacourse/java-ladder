package ladder.View;

import ladder.domain.Direction;
import ladder.domain.Line;
import ladder.domain.Player;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String OUTPUT_LADDER_RESULT = "사다리 결과";
    private static final String OUTPUT_EXECUTE_RESULT = "실행 결과";
    private static final String ROW_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String COL_LINE = "|";
    private static final String NEXT_LINE = "\n";
    private static final String NAME_REWARD_SEPARATOR = " : ";
    private static StringBuilder stringBuilder;

    public static void ladderResult(List<Player> players, List<Line> ladder, Map<Integer, String> gameRewards) {
        stringBuilder = new StringBuilder();
        System.out.println(OUTPUT_LADDER_RESULT);
        printPlayers(players);
        printLadder(ladder);
        printReward(gameRewards);
        System.out.println(stringBuilder.toString());
    }

    private static void printPlayers(List<Player> players) {
        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player.getName()));
        }
        stringBuilder.append(NEXT_LINE);
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

    private static void printReward(Map<Integer, String> gameRewards) {
        Collection<String> values = gameRewards.values();

        for (String value : values) {
            stringBuilder.append(String.format("%6s", value));
        }
        stringBuilder.append(NEXT_LINE);
    }

    public static void printOnePlayerResult(Player player, Map<Integer, String> gameRewards) {
        stringBuilder = new StringBuilder();
        int resultPosition = player.getPosition();

        stringBuilder.append(OUTPUT_EXECUTE_RESULT)
                .append(NEXT_LINE)
                .append(gameRewards.get(resultPosition))
                .append(NEXT_LINE);

        System.out.println(stringBuilder.toString());
    }

    public static void printAllPlayersResult(List<Player> players, Map<Integer, String> gameRewards) {
        stringBuilder = new StringBuilder();

        stringBuilder.append(OUTPUT_EXECUTE_RESULT)
                .append(NEXT_LINE);
        for (Player player : players) {
            int resultPosition = player.getPosition();
            stringBuilder.append(player.getName())
                    .append(NAME_REWARD_SEPARATOR)
                    .append(gameRewards.get(resultPosition))
                    .append(NEXT_LINE);
        }
        System.out.println(stringBuilder.toString());
    }
}
