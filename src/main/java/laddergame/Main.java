package laddergame;

import laddergame.controller.LadderGameController;

public class Main {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.init();
        ladderGameController.proceedGame();
    }
}
