package ladder;

import ladder.controller.LadderController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        LadderController ladderController = new LadderController();
        ladderController.init();
        ladderController.printResult();
    }
}
