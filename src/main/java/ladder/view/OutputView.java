package ladder.view;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.laddergame.LadderGameResult;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;

import java.util.stream.Collectors;

public class OutputView {
    private static final String PRINT_FORMAT = "%-6s";
    private static final String CONNECTOR = "\t\t";
    private static final String CONNECTED_LINE_COMPONENT = "|-----------";
    private static final String NOT_CONNECTED_LINE_COMPONENT = "|           ";
    private static final String ALL = "all";

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        for (Direction direction : line.getDirections()) {
            printLineComponent(direction);
        }
        System.out.println();
    }

    private static void printLineComponent(Direction direction) {
        if (Direction.isRight(direction)) {
            System.out.print(CONNECTED_LINE_COMPONENT);
            return;
        }
        System.out.print(NOT_CONNECTED_LINE_COMPONENT);
    }

    public static void printPlayers(Players players) {
        String joinedPlayer = players.getPlayers().stream()
                .map(player -> String.format(PRINT_FORMAT, player.getName()))
                .collect(Collectors.joining(CONNECTOR));
        System.out.println(joinedPlayer);
    }

    public static void printRewards(Rewards rewards) {
        String joinedReward = rewards.getRewards().stream()
                .map(reward -> String.format(PRINT_FORMAT, reward.getReward()))
                .collect(Collectors.joining(CONNECTOR));
        System.out.println(joinedReward);
    }

    public static void printLadderGameResult(LadderGameResult ladderGameResult, String name) {
        if (ALL.equals(name)) {
            printAllPlayerForReward(ladderGameResult);
            return;
        }
        System.out.println(ladderGameResult.findReward(name));
    }

    private static void printAllPlayerForReward(LadderGameResult ladderGameResult) {
        for (Player player : ladderGameResult.keySet()) {
            System.out.println(player.getName() + " : " + ladderGameResult.findReward(player.getName()));
        }
    }
}
