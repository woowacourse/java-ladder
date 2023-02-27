package ladder;

import ladder.controller.FrontExceptionController;
import ladder.controller.LadderGameController;

public class Application {

    public static void main(String[] args) {
        new LadderGameController(new FrontExceptionController()).run();
    }
}
