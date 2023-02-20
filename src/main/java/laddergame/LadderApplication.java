package laddergame;

import laddergame.controller.LadderController;
import laddergame.domain.RandomBooleanGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(), new OutputView(), new RandomBooleanGenerator());
        ladderController.run();
    }
}
