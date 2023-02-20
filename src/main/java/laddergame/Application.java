package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.util.RandomTrueOrFalseGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderGameController ladderGameController =
                new LadderGameController(new InputView(), new OutputView(), new RandomTrueOrFalseGenerator());
        ladderGameController.run();
    }
}
