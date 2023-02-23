package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.domain.rung.RungGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderGameController gameController = new LadderGameController(
                new InputView(), new OutputView(), new RungGenerator()
        );
        gameController.start();
    }
}
