package ladder;

import ladder.controller.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new InputView(), new OutputView());
        ladderGame.run();
    }
}
