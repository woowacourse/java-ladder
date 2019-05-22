package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.view.InputView;

public class Main {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.init();
        ladderGameController.proceedGame();
    }
}
