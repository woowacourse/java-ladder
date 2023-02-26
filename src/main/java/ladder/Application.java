package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.ladder.LineStrategy;
import ladder.domain.ladder.NoncontinuousRandomLineStrategy;

public class Application {
    public static void main(String[] args) {
        LineStrategy lineStrategy = new NoncontinuousRandomLineStrategy();
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.playGame(lineStrategy);
    }
}
