package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class OutputView {
    public static void showPlayersAndLadder(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        System.out.println("실행 결과\n");
        printPlayerNames(players);
        printLadder(ladder, resultItems);
    }

    private static void printPlayerNames(PlayerGroup players) {
        for (Player player : players.getPlayers()) {
            System.out.print(String.format("%-6s", player));
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder, ResultItems resultItems) {
        for (Crosspoints crosspoints : ladder.getLadderRows()) {
            printCrossbars(crosspoints);
            System.out.println();
        }

        for (ResultItem resultItem : resultItems.getResultItems()) {
            System.out.print(String.format("%-6s", resultItem));
        }
        System.out.println();
    }

    private static void printCrossbars(Crosspoints crosspoints) {
        for (Boolean rightCrossbar : crosspoints.getRightSideCrossbars()) {
            if (rightCrossbar) {
                System.out.print("|-----");
                continue;
            }
            System.out.print(String.format("%-6s", "|"));
        }
    }

    public static void showResultOf(String playerName, LadderResult ladderingResult) {
        System.out.println("실행 결과");
        if (playerName.equals("all")) {
            showAllResultOf(ladderingResult.getResultAll());
            return;
        }
        System.out.println(ladderingResult.getResultOf(playerName));
    }

    private static void showAllResultOf(Map<Player, ResultItem> ladderingResult) {
        for (Player player : ladderingResult.keySet()) {
            System.out.println(player + " : " + ladderingResult.get(player));
        }
    }
}
