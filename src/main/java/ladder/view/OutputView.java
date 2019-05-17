package ladder.view;

import ladder.constant.MessageConstant;
import ladder.model.Ladder;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    private static final String NEW_LINE = "\n";

    public static void showLadderGame(List<String> names, Ladder ladder, List<String> goalNames) {
        System.out.println(NEW_LINE + MessageConstant.OUTPUT_LADDER_GAME_RESULT + NEW_LINE);
        showLadderPlayers(names);
        showLadder(ladder);
        showLadderGoals(goalNames);
    }

    private static void showLadderPlayers(List<String> playerNames) {
        for (String playerName : playerNames) {
            System.out.print(playerName);
        }
        System.out.println();
    }

    private static void showLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    private static void showLadderGoals(List<String> goalNames) {
        for (String goalName : goalNames) {
            System.out.print(goalName);
        }
        System.out.println();
    }

    public static void showMatchingResult(String targetResult) {
        if (targetResult != null) {
            System.out.println(NEW_LINE + MessageConstant.OUTPUT_ACTION_RESULT);
            System.out.println(targetResult);
        }
    }
}
