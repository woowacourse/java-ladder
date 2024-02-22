package laddergame;

import laddergame.controller.LadderController;
import laddergame.service.LadderGame;
import laddergame.domain.RandomBooleanGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final LadderController ladderController = new LadderController(new InputView(), new OutputView(), new LadderGame(new RandomBooleanGenerator()));
        ladderController.run();
    }
}
