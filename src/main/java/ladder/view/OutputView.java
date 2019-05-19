package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;

public class OutputView {
    private static final String PRINT_FORMAT = "%-6s";
    private static final String CONNECTOR = "\t\t";
    private static final String CONNECTED_LINE_COMPONENT = "|-----------";
    private static final String NOT_CONNECTED_LINE_COMPONENT = "|           ";

    public static void printLadder(Ladder ladder){
        for (Line line : ladder.getLines()){
            for(Direction direction : line.getDirections()){
                if(direction == Direction.RIGHT){
                    System.out.print(CONNECTED_LINE_COMPONENT);
                    continue;
                }
                System.out.print(NOT_CONNECTED_LINE_COMPONENT);
            }
            System.out.println();
        }
    }

    // TODO interface 적용해서 중복코드 줄여보기? (Players, Rewards)
    public static void printPlayers(Players players) {
        String joinedPlayer = players.getPlayers().stream()
                .map(player -> String.format(PRINT_FORMAT, player.getName()))
                .collect(Collectors.joining(CONNECTOR));
        System.out.println(joinedPlayer);
    }

    public static void printRewards(Rewards rewards) {
        String joinedPlayer = rewards.getRewards().stream()
                .map(reward -> String.format(PRINT_FORMAT, reward.getReward()))
                .collect(Collectors.joining(CONNECTOR));
        System.out.println(joinedPlayer);
    }
}
