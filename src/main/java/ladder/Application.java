package ladder;

import ladder.controller.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderGame controller = new LadderGame(new InputView(), new OutputView());
        controller.run();
    }
}
