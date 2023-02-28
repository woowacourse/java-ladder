package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(
                new InputView(),
                new OutputView()
        );

        controller.run();
    }
}
