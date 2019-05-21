package ladder.view;

import ladder.constant.MessageConstant;
import ladder.model.Ladder;
import ladder.model.LadderGameGoals;
import ladder.model.LadderGamePlayers;
import ladder.model.LadderGameResult;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    private static final String COLON_WITH_SPACE = " : ";
    private static final String NEW_LINE = "\n";

    public static void showLadderGame(LadderGamePlayers players, Ladder ladder, LadderGameGoals goals) {
        System.out.println(NEW_LINE + MessageConstant.OUTPUT_LADDER_GAME_RESULT + NEW_LINE);
        showLadderPlayers(players);
        showLadder(ladder);
        showLadderGoals(goals);
    }

    private static void showLadderPlayers(LadderGamePlayers players) {
        for (String playerName : players.getAllAlignedPlayerNames()) {
            System.out.print(playerName);
        }
        System.out.println();
    }

    private static void showLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    private static void showLadderGoals(LadderGameGoals goals) {
        for (String goalName : goals.getAlignedGoalNames()) {
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

    public static void showMatchingResult(LadderGameResult ladderGameResult) {
        List<String> keys = ladderGameResult.getPlayerNames();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ladderGameResult.size(); i++) {
            stringBuilder.append(keys.get(i))
                    .append(COLON_WITH_SPACE)
                    .append(ladderGameResult.matchResult(keys.get(i)))
                    .append(NEW_LINE);
        }
        showMatchingResult(stringBuilder.toString());
    }
}
