package ladder.view;

import ladder.model.Ladder;
import ladder.model.Players;

public class OutputView {

    public static void printResultOfLadder(Players players, Ladder ladder) {
        System.out.println("사다리 결과");
        System.out.println(players.toString());
        System.out.println(ladder.toString());
    }

}
