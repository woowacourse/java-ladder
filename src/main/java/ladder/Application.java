package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.LineStrategy;
import ladder.domain.NonContinuousRandomLineStrategy;

public class Application {
    public static void main(String[] args) {
        LineStrategy lineStrategy = new NonContinuousRandomLineStrategy();
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.playGame(lineStrategy);
    }
}
