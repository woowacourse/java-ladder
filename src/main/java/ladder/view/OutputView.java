package ladder.view;

import ladder.constant.MessageConstant;
import ladder.model.Ladder;

import java.util.List;

public class OutputView {

    public static final String ENTER = "\n";

    public static void showLadderGame(List<String> names, Ladder ladder) {
        System.out.println(MessageConstant.OUPUT_RESULT);
        showPlayers(names);
        showLadder(ladder);
    }

    private static void showPlayers(List<String> names) {
        for (String name : names) {
            System.out.print(name);
        }
    }

    private static void showLadder(Ladder ladder) {
        System.out.println(ENTER + ladder);
    }

}
