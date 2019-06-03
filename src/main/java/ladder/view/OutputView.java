package ladder.view;

import ladder.domain.*;

import java.util.HashMap;
import java.util.Map;

public class OutputView {
    public static void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

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
        for (LadderRow ladderRow : ladder.getLadderRows()) {
            printCrossbars(ladderRow);
            System.out.println();
        }
    }

    private static void printResultItems(ResultItems resultItems) {
        for (int position = 0; position < resultItems.size(); position++) {
            System.out.print(String.format("%-6s", resultItems.getResultItemAtPositionOf(position)));
        }
        System.out.println();
    }

    private static void printCrossbars(LadderRow ladderRow) {
        for (Boolean rightCrossbar : ladderRow.getRightSideCrossbars()) {
            if (rightCrossbar) {
                System.out.print("|-----");
                continue;
            }
            System.out.print(String.format("%-6s", "|"));
        }
    }

    public static void showResultOf(String playerName, LadderingResult ladderingResult) {
        HashMap<Player, LadderItem> foundResult = ladderingResult.findResultOf(playerName);

        for (Map.Entry<Player, LadderItem> result : foundResult.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
    }
}
