package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.LineStrategy;
import ladder.domain.NoncontinuousRandomLineStrategy;

public class Application {
    public static void main(String[] args) {
        LineStrategy lineStrategy = new NoncontinuousRandomLineStrategy();
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.playGame(lineStrategy);
    }
}
