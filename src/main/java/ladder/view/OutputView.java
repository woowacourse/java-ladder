package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class OutputView {
    public static void showPlayersAndLadder(PlayerGroup players, Ladder ladder) {
        System.out.println("실행 결과\n");
        printPlayerNames(players);
        printLadder(ladder);
    }

    private static void printPlayerNames(PlayerGroup players) {
        for (Player player : players.getPlayers()) {
            System.out.print(String.format("%-6s", player));
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (Crosspoints crosspoints : ladder.getLadder()) {
            printCrossbars(crosspoints);
            System.out.println();
        }

        for (ResultItem resultItem : ladder.getResultItems()) {
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

    public static void showResultOf(String playerName, Map<String, ResultItem> ladderingResult) {
        System.out.println("실행 결과");
        if (playerName.equals("all")) {
            showAllResultOf(ladderingResult);
            return;
        }

        if (!ladderingResult.containsKey(playerName)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }

        System.out.println(ladderingResult.get(playerName));
    }

    private static void showAllResultOf(Map<String, ResultItem> ladderingResult) {
        for (String playerName : ladderingResult.keySet()) {
            System.out.println(playerName + " : " + ladderingResult.get(playerName));
        }
    }
}
