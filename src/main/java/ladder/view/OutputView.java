package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class OutputView {
    public static void showPlayersAndLadder(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        System.out.println("실행 결과\n");
        printPlayerNames(players);
        printLadder(ladder);
        printResultItems(resultItems);
    }

    private static void printPlayerNames(PlayerGroup players) {
        for (Player player : players.getPlayers()) {
            System.out.print(String.format("%-6s", player));
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (Crosspoints crosspoints : ladder.getLadderRows()) {
            printCrossbars(crosspoints);
            System.out.println();
        }
    }

    private static void printResultItems(ResultItems resultItems) {
        for (int position = 0; position < resultItems.size(); position++) {
            System.out.print(String.format("%-6s", resultItems.getResultItemAtPositionOf(position)));
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

    public static void showResultOf(String playerName, Map<Player, ResultItem> ladderingResult) {
        if (playerName.equals("all")) {
            showAllResultOf(ladderingResult);
            return;
        }

        showPlayerResult(playerName, ladderingResult);
    }

    private static void showAllResultOf(Map<Player, ResultItem> ladderingResult) {
        for (Player player : ladderingResult.keySet()) {
            System.out.println(player + " : " + ladderingResult.get(player));
        }
    }

    private static void showPlayerResult(String playerName, Map<Player, ResultItem> ladderingResult) {
        Player player = new Player(playerName);

        if (!ladderingResult.containsKey(player)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }

        System.out.println(ladderingResult.get(player));
    }
}
