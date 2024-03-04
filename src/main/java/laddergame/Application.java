package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderGameController ladderGameController = new LadderGameController(inputView, outputView);
        ladderGameController.run();
    }
}
