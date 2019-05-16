package ladder.view;

import ladder.domain.Crosspoints;
import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.PlayerGroup;

public class OutputView {
    public static void showPlayersAndLadder(PlayerGroup players, Ladder ladder) {
        System.out.println("실행 결과\n");
        for (Player player : players.getPlayers()) {
            System.out.print(String.format("%-6s", player));
        }
        System.out.println();

        for (Crosspoints crosspoints : ladder.getLadder()) {
            printCrosspoints(crosspoints);
            System.out.println();
        }
    }

    private static void printCrosspoints(Crosspoints crosspoints) {
        for (Boolean rightCrossbar : crosspoints.getRightCrossbars()) {
            if (rightCrossbar) {
                System.out.print("|-----");
                continue;
            }
            System.out.print(String.format("%-6s", "|"));
        }
    }
}
