package ladder.view;

import ladder.domain.*;

import java.util.HashMap;

public class OutputView {
    public static void showPlayersAndLadder(PlayerGroup players, Ladder ladder, ResultItems resultItems) {
        System.out.println("실행 결과\n");
        for (Player player : players.getPlayers()) {
            System.out.print(String.format("%-6s", player));
        }
        System.out.println();

        for (Crosspoints crosspoints : ladder.getLadder()) {
            printCrosspoints(crosspoints);
            System.out.println();
        }

        for (ResultItem resultItem : resultItems.getResultItems()) {
            System.out.print(String.format("%-6s", resultItem));
        }
        System.out.println();
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

    public static void showladderingResult(HashMap<String, ResultItem> ladderingResult) {
        String playerNameToShowResult = InputView.inputPlayerNameToShowResult();

        if (!ladderingResult.keySet().contains(playerNameToShowResult)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }

        if (playerNameToShowResult.equals("all")) {
            for (String playerName : ladderingResult.keySet()) {
                System.out.println(playerName + " : " + ladderingResult.get(playerName));
            }
            return;
        }

        System.out.println(ladderingResult.get(playerNameToShowResult));
    }
}
