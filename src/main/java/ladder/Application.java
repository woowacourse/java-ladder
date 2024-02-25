package ladder;

import ladder.controller.LadderCreator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderCreator ladderCreator = new LadderCreator(new InputView(), new OutputView());
        ladderCreator.run();
    }
}
