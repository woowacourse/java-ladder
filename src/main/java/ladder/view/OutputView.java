package ladder.view;

import ladder.MessageCollection;
import ladder.model.Ladder;

import java.util.List;

public class OutputView {

    public static final String ENTER = "\n";

    public static void showLadderGame(List<String> names, Ladder ladder, List<String> goalNames) {
        System.out.println(ENTER + MessageCollection.OUTPUT_LADDER_RESULT + ENTER);
        showPlayers(names);
        showLadder(ladder);
        showGoals(goalNames);
    }

    private static void showPlayers(List<String> names) {
        for (String name : names) {
            System.out.print(name);
        }
        System.out.println();
    }

    private static void showLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    private static void showGoals(List<String> goalNames) {
        for (String goal : goalNames) {
            System.out.print(goal);
        }
        System.out.println();
    }

    public static void showGameResult(String foundGoal) {
        if (foundGoal != null) {
            System.out.println(ENTER + MessageCollection.OUTPUT_RESULT);
            System.out.println(foundGoal);
        }
    }

}
