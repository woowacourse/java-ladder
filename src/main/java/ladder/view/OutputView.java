package ladder.view;

import ladder.constant.MessageConstant;
import ladder.model.Ladder;

import java.util.List;

public class OutputView {

    public static final String ENTER = "\n";

    public static void showLadderGame(List<String> names, Ladder ladder, List<String> goalNames) {
        System.out.println(MessageConstant.OUPUT_RESULT);
        showPlayers(names);
        showLadder(ladder);
        showGoals(goalNames);
    }

    private static void showPlayers(List<String> names) {
        for (String name : names) {
            System.out.print(name);
        }
    }

    private static void showLadder(Ladder ladder) {
        System.out.println(ENTER + ladder);
    }

    private static void showGoals(List<String> goalNames) {
        for (String goal : goalNames) {
            System.out.print(goal);
        }
    }
}
