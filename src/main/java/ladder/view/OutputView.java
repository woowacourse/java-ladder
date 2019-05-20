package ladder.view;

import ladder.domain.DrawnLadder;
import ladder.domain.Player;
import ladder.domain.Position;
import ladder.domain.Reward;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLadderGameBoard(DrawnLadder drawnLadder, List<Player> players, List<Reward> rewards) {
        System.out.println("사다리 결과");
        printNames(players.stream().map(player -> player.getName()).collect(Collectors.toList()));
        printDrawnLadder(drawnLadder);
        printNames(rewards.stream().map(reward -> reward.getName()).collect(Collectors.toList()));
    }

    private static void printNames(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.printf("\n");
    }

    public static void printDrawnLadder(DrawnLadder drawnLadder) {
        String verticalLine = "|";
        String horizontalLine = "-----";
        String emptyHorizontalLine = "     ";

        System.out.println("사다리 출력");
        for (Position r : drawnLadder.createFirstRowPosition().begin()) {
            System.out.print(emptyHorizontalLine);
            System.out.print(verticalLine);
            for (Position c : drawnLadder.createFirstLeftColumnPosition().begin()) {
                System.out.print(drawnLadder.isDrawn(r, c) ? horizontalLine : emptyHorizontalLine);
                System.out.print(verticalLine);
            }
            System.out.print("\n");
        }
    }


}
